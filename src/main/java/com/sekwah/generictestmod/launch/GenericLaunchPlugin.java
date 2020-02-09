package com.sekwah.generictestmod.launch;

import cpw.mods.modlauncher.api.IEnvironment;
import cpw.mods.modlauncher.api.ITransformationService;
import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.IncompatibleEnvironmentException;
import cpw.mods.modlauncher.serviceapi.ILaunchPluginService;
import joptsimple.ArgumentAcceptingOptionSpec;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.launch.MixinLaunchPlugin;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class GenericLaunchPlugin implements ILaunchPluginService {
    @Override
    public String name() {
        System.out.println("NAMING");
        return "mixins";
    }

    @Override
    public EnumSet<Phase> handlesClass(Type classType, boolean isEmpty) {
        return EnumSet.noneOf(Phase.class);
    }

    @Override
    public boolean processClass(Phase phase, ClassNode classNode, Type classType) {
        return false;
    }
}
