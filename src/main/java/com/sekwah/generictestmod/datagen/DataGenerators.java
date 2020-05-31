package com.sekwah.generictestmod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        /**
         * Packages on data are located at {@link net.minecraft.data}
         *
         * TODO make basic examples for each fully working.
         */
        if(event.includeServer()) {
            gen.addProvider(new RecipeGen(gen));
            gen.addProvider(new LootTableGen(gen));
            // TODO loot tables
        }

        if(event.includeClient()) {
            gen.addProvider(new BlockStateGen(gen, event.getExistingFileHelper()));
            // TODO BlockStates
        }
    }

}
