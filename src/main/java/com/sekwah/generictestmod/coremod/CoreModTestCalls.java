package com.sekwah.generictestmod.coremod;

import com.sekwah.generictestmod.GenericTestMod;

/**
 * {@link net.minecraftforge.coremod.api.ASMAPI}
 */
public class CoreModTestCalls {

    public static void basicTestCall() {
        GenericTestMod.LOGGER.debug("Main menu basic insert trigger ASM");
    }

    public static void classTestCall() {
        GenericTestMod.LOGGER.debug("Main menu class insert trigger ASM");
    }

}
