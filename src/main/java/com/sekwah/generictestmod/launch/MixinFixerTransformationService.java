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

    private MixinTransformationService mixinTransformationService;

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
        // can take over.
        try {
            launchPlugins = (LaunchPluginHandler) launchPluginsField.get(Launcher.INSTANCE);
            if(launchPlugins.get("mixin").isPresent()) {
                shouldProcessMixins = false;
                return;
            }
        } catch (IllegalAccessException e) {
            LOGGER.error("Error getting data from Launcher", e);
            return;
        }

        try {
            Map<String, ILaunchPluginService> pluginList = getPluginList();
            pluginList.put("mixin", new MixinLaunchPlugin());

            if(!otherServices.contains("mixin")) {
                mixinTransformationService = new MixinTransformationService();
                mixinTransformationService.onLoad(env, otherServices);
            }
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
