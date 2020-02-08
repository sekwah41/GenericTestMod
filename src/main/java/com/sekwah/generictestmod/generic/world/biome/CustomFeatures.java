package com.sekwah.generictestmod.generic.world.biome;

import com.sekwah.generictestmod.generic.block.GenericBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

public class CustomFeatures {

    public static final TreeFeatureConfig OBSIDIAN_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OBSIDIAN.getDefaultState()), new SimpleBlockStateProvider(Blocks.DIAMOND_ORE.getDefaultState()), new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable) GenericBlocks.OBSIDIAN_TREE.get()).build();

}
