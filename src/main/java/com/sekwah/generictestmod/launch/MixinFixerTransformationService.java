package com.sekwah.generictestmod.launch;

import com.google.common.collect.ImmutableList;
import cpw.mods.modlauncher.LaunchPluginHandler;
import cpw.mods.modlauncher.Launcher;
import cpw.mods.modlauncher.ServiceLoaderStreamUtils;
import cpw.mods.modlauncher.api.IEnvironment;
import cpw.mods.modlauncher.api.ITransformationService;
import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.IncompatibleEnvironmentException;
import cpw.mods.modlauncher.serviceapi.ILaunchPluginService;
import joptsimple.OptionSpecBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.spongepowered.asm.launch.MixinLaunchPlugin;
import org.spongepowered.asm.launch.MixinTransformationService;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.BiFunction;

public class MixinFixerTransformationService implements ITransformationService {

    public Logger LOGGER = LogManager.getLogger("Generic Mod TransService");

    private boolean shouldProcessMixins = true;

    private LaunchPluginHandler launchPlugins;

    private Map<String, ILaunchPluginService> pluginList;

    private MixinTransformationService mixinTransformationService;

    Marker MODLAUNCHER = MarkerManager.getMarker("MODLAUNCHER");
    Marker CLASSLOADING = MarkerManager.getMarker("CLASSLOADING").addParents(MODLAUNCHER);
    Marker LAUNCHPLUGIN = MarkerManager.getMarker("LAUNCHPLUGIN").addParents(MODLAUNCHER);

    @Nonnull
    @Override
    public String name() {
        // Add your own modname so they dont clash
        return "genericmixins";
    }

    @Override
    public void initialize(IEnvironment environment) {
        if(mixinTransformationService != null) mixinTransformationService.initialize(environment);
    }

    @Override
    public void beginScanning(IEnvironment environment) {
        if(mixinTransformationService != null) mixinTransformationService.beginScanning(environment);
    }


    @Override
    public void onLoad(IEnvironment env, Set<String> otherServices) throws IncompatibleEnvironmentException {

        // Don't grab this before in case someone else does something stupid such as replacing the list.
        // If mixins are detected skip any other processing so that whatever other plugin that has registered it
        // can take over

        LOGGER.info("Checking services");
        ServiceLoader<ILaunchPluginService> services = ServiceLoaderStreamUtils.errorHandlingServiceLoader(ILaunchPluginService.class,
                e->LOGGER.fatal(MODLAUNCHER, "Encountered serious error loading launch plugin service. Things will not work well", e));
        Map<String, ILaunchPluginService> plugins = ServiceLoaderStreamUtils.toMap(services, ILaunchPluginService::name);
        for(Map.Entry<String, ILaunchPluginService> plugin : plugins.entrySet()) {
            LOGGER.info("{} test {}", plugin.getKey(), plugin.getValue());
        }

        LOGGER.info("Looking to add mixins");
        try {
            launchPlugins = (LaunchPluginHandler) launchPluginsField.get(Launcher.INSTANCE);
            if(launchPlugins.get("mixin").isPresent()) {
                LOGGER.info("Mixins already found");
                shouldProcessMixins = false;
                return;
            }
        } catch (IllegalAccessException e) {
            LOGGER.error("Error getting data from Launcher", e);
            return;
        }

        try {
            LOGGER.info("Attempting to add mixins");
            pluginList = getPluginList();
            //pluginList.put("mixin", new MixinLaunchPlugin());
            addLaunchPlugin("mixin", new MixinLaunchPlugin());

            if(!otherServices.contains("mixin")) {
                mixinTransformationService = new MixinTransformationService();
                mixinTransformationService.onLoad(env, otherServices);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void addLaunchPlugin(String name, ILaunchPluginService launchPluginService) {
        pluginList.put("mixin", new MixinLaunchPlugin());
        HashMap<String,String> mod = new HashMap<>();
        mod.put("name", name);
        mod.put("type", "PLUGINSERVICE");
        String fName = launchPluginService.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        mod.put("file", fName.substring(fName.lastIndexOf("/")));
        if (Launcher.INSTANCE!=null) {
            final List<Map<String, String>> mods = Launcher.INSTANCE.environment().getProperty(IEnvironment.Keys.MODLIST.get()).orElseThrow(() -> new RuntimeException("The MODLIST isn't set, huh?"));
            mods.add(mod);
        }
    }

    /**
     * @return null if launchPlugins can't be fetched or before onLoad is called.
     * @throws IllegalAccessException
     */
    public Map<String, ILaunchPluginService> getPluginList() throws IllegalAccessException {
        if(launchPlugins == null) {
            return null;
        }
        return (Map<String, ILaunchPluginService>) launchPluginListField.get(launchPlugins);
    }


    private Field launchPluginsField;
    private Field launchPluginListField;

    {
        try {
            launchPluginsField = Launcher.class.getDeclaredField("launchPlugins");
            launchPluginsField.setAccessible(true);
            launchPluginListField = LaunchPluginHandler.class.getDeclaredField("plugins");
            launchPluginListField.setAccessible(true);


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void arguments(BiFunction<String, String, OptionSpecBuilder> argumentBuilder) {
        if(mixinTransformationService != null) mixinTransformationService.arguments(argumentBuilder);
    }

    @Override
    public void argumentValues(OptionResult option) {
        if(mixinTransformationService != null) mixinTransformationService.argumentValues(option);
    }

    @Nonnull
    @Override
    public List<ITransformer> transformers() {
        return ImmutableList.<ITransformer>of();
    }
}
