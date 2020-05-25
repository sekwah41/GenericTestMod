package com.sekwah.generictestmod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.LootTableProvider;

public class LootTableGen extends LootTableProvider {
    public LootTableGen(DataGenerator gen) {
        super(gen);
    }

    @Override
    public void act(DirectoryCache cache) {
    }

    @Override
    public String getName() {
        return "GenericTestMod LootTables";
    }
}
