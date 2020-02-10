package com.sekwah.generictestmod.launch;

import cpw.mods.modlauncher.TransformingClassLoader;
import cpw.mods.modlauncher.serviceapi.ILaunchPluginService;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class ProvideMixinPackages implements ILaunchPluginService {

    @Override
    public String name() {
        return "genericmixins";
    }

    @Override
    public EnumSet<Phase> handlesClass(Type classType, boolean isEmpty) {
        return EnumSet.<Phase>noneOf(Phase.class);
    }

    @Override
    public boolean processClass(Phase phase, ClassNode classNode, Type classType) {
        return false;
    }
}
