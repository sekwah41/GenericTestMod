package com.sekwah.generictestmod.launch;

import cpw.mods.modlauncher.api.IEnvironment;
import cpw.mods.modlauncher.api.ITransformationService;
import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.IncompatibleEnvironmentException;
import joptsimple.ArgumentAcceptingOptionSpec;
import org.spongepowered.asm.launch.MixinLaunchPlugin;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MixinTransformationService implements ITransformationService {

    private ArgumentAcceptingOptionSpec<String> mixinsArgument;
    private List<String> commandLineMixins = new ArrayList<String>();
    private MixinLaunchPlugin plugin;

    @Nonnull
    @Override
    public String name() {
        return MixinLaunchPlugin.NAME;
    }

    @Override
    public void initialize(IEnvironment environment) {
        System.out.println("Initialise");
    }

    @Override
    public void beginScanning(IEnvironment environment) {
        System.out.println("Begin scanning");
    }

    @Override
    public void onLoad(IEnvironment env, Set<String> otherServices) throws IncompatibleEnvironmentException {
        System.out.println("OnLoad");
    }

    @Nonnull
    @Override
    public List<ITransformer> transformers() {
        return new ArrayList<>();
    }
}
