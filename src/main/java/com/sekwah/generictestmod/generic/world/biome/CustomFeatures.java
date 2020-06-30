package com.sekwah.generictestmod.generic.world.biome;

import com.sekwah.generictestmod.generic.block.GenericBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class CustomFeatures {

    public static final BaseTreeFeatureConfig OBSIDIAN_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OBSIDIAN.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.DIAMOND_ORE.getDefaultState()),
            new BlobFoliagePlacer(2, 0, 0, 0, 3),
            new StraightTrunkPlacer(5, 2, 0),
            new TwoLayerFeature(1, 0, 1)).func_236700_a_()
    ).func_236700_a_().build();

}
