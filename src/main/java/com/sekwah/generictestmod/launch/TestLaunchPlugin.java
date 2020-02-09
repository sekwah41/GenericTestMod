package com.sekwah.generictestmod.launch;

import cpw.mods.modlauncher.serviceapi.ILaunchPluginService;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;

import java.util.EnumSet;

public class TestLaunchPlugin implements ILaunchPluginService {
    @Override
    public String name() {
        return "generictestlaunchplugin";
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
