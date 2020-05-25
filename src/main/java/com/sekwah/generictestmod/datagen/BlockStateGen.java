package com.sekwah.generictestmod.datagen;

import com.mojang.datafixers.types.DynamicOps;
import com.sekwah.generictestmod.GenericConstants;
import com.sekwah.generictestmod.GenericTestMod;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import java.util.Random;

public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, GenericConstants.MOD_ID, exFileHelper);

    }

    @Override
    protected void registerStatesAndModels() {

    }
}
