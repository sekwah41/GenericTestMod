package com.sekwah.generictestmod.launch;

import cpw.mods.modlauncher.serviceapi.ILaunchPluginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;

import java.util.EnumSet;

public class TestLaunchPlugin implements ILaunchPluginService {

    public Logger LOGGER = LogManager.getLogger("Generic Mod Test");

    public TestLaunchPlugin() {
        // Just here to test if the launch plugin is detected or not
        LOGGER.info("Launch plugin triggered");
    }

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
