package com.sekwah.generictestmod.generic.block.tree;

import com.sekwah.generictestmod.generic.world.biome.CustomFeatures;
import com.sekwah.generictestmod.generic.world.gen.feature.GenericFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class ObsidianTree extends Tree {

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random p_225546_1_, boolean p_225546_2_) {
        return GenericFeatures.SOLID_FANCY_TREE_FEATURE.get().configure(/*DefaultBiomeFeatures.BIRCH_TREE_CONFIG*/CustomFeatures.OBSIDIAN_TREE_CONFIG);
    }
}
