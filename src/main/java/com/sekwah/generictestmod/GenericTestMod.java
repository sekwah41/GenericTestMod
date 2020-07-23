package com.sekwah.generictestmod;

import com.sekwah.generictestmod.generic.block.GenericBlocks;
import com.sekwah.generictestmod.generic.items.GenericItems;
import com.sekwah.generictestmod.generic.world.gen.GenGen;
import com.sekwah.generictestmod.generic.world.gen.feature.GenericFeatures;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;

/**
 * For asm reference {@link net.minecraftforge.coremod.api.ASMAPI}
 */
@Mod("generictestmod")
public class GenericTestMod {

    public static final Logger LOGGER = LogManager.getLogger("Generic Mod Test");

    public GenericTestMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);

        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);

        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);

        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        eventBus.addListener(this::onServerStarting);


        GenericItems.register(eventBus);

        GenericBlocks.register(eventBus);

        GenericFeatures.register(eventBus);

        /*
            Wrap your code in this stuff so it doesn't crash if its not loaded. If you get crashes for missing classes
            you have not properly separated your code. This goes for server errors and missing mods
         */
        if(ModList.get().isLoaded("jei")) {

        }

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        // init gen features
        GenGen.addFeatures();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("generictestmod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

}
