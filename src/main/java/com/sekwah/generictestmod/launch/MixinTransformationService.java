package com.sekwah.generictestmod.launch;

import cpw.mods.modlauncher.Environment;
import cpw.mods.modlauncher.Launcher;
import cpw.mods.modlauncher.api.IEnvironment;
import cpw.mods.modlauncher.api.ITransformationService;
import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.IncompatibleEnvironmentException;
import cpw.mods.modlauncher.serviceapi.ILaunchPluginService;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MixinTransformationService implements ITransformationService {

    private boolean mixinsAlreadyLoaded = false;

    @Nonnull
    @Override
    public String name() {
        // Add your own modname so they dont clash
        return "genericmixins";
    }

    @Override
    public void initialize(IEnvironment environment) {

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
        /**
         * In case mixins are properly fixed
         */
        /*if(otherServices.contains("mixin")) {
            mixinsAlreadyLoaded = true;
            System.out.println("Mixin's are already loaded");
            return;
        }*/

        //Launcher.INSTANCE;

        /*try {
            Field launcherF = Environment.class.getDeclaredField("launcher");
            launcherF.setAccessible(true);
            Launcher launcher = (Launcher) launcherF.get(env);
            System.out.println("Test");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }*/
    }

    @Nonnull
    @Override
    public List<ITransformer> transformers() {
        return new ArrayList<>();
    }
}
