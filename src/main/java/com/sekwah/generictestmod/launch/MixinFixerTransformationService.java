package com.sekwah.generictestmod.launch;

import cpw.mods.modlauncher.LaunchPluginHandler;
import cpw.mods.modlauncher.Launcher;
import cpw.mods.modlauncher.ServiceLoaderStreamUtils;
import cpw.mods.modlauncher.api.IEnvironment;
import cpw.mods.modlauncher.api.ITransformationService;
import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.IncompatibleEnvironmentException;
import cpw.mods.modlauncher.serviceapi.ILaunchPluginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.spongepowered.asm.launch.MixinLaunchPlugin;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.*;

public class MixinFixerTransformationService implements ITransformationService {

    public Logger LOGGER = LogManager.getLogger("Generic Mod TransService");

    private boolean mixinsAlreadyLoaded = false;

    private LaunchPluginHandler launchPlugins;

    private Marker MODLAUNCHER = MarkerManager.getMarker("MODLAUNCHER");

    @Nonnull
    @Override
    public String name() {
        // Add your own modname so they dont clash
        return "genericmixins";
    }

    @Override
    public void initialize(IEnvironment environment) {

        LOGGER.info("initialize");
        if(mixinsAlreadyLoaded) return;

        Optional<ILaunchPluginService> mixinLaunchPlugin = environment.findLaunchPlugin("mixin");
        if(mixinLaunchPlugin.isPresent()) {
            return;
        }
    }

    @Override
    public void beginScanning(IEnvironment environment) {
        System.out.println(environment);
    }


    @Override
    public void onLoad(IEnvironment env, Set<String> otherServices) throws IncompatibleEnvironmentException {

        // Don't grab this before in case someone else does something stupid such as replacing the list.
        try {
            launchPlugins = (LaunchPluginHandler) launchPluginsField.get(Launcher.INSTANCE);
            if(launchPlugins.get("mixin").isPresent()) {
                mixinsAlreadyLoaded = true;
                return;
            }
        } catch (IllegalAccessException e) {
            LOGGER.error("Error getting data from Launcher", e);
            return;
        }

        // TODO add checks to make sure another mod hasn't added mixins poorly.

        try {
            Map<String, ILaunchPluginService> pluginList = getPluginList();
            pluginList.put("mixin", new MixinLaunchPlugin());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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

    @Nonnull
    @Override
    public List<ITransformer> transformers() {
        return new ArrayList<>();
    }
}
