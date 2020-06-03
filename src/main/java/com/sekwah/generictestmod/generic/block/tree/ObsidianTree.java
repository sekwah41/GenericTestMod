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
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random rand, boolean switcharoo) {
        return GenericFeatures.SOLID_FANCY_TREE_FEATURE.get().withConfiguration(/*DefaultBiomeFeatures.BIRCH_TREE_CONFIG*/CustomFeatures.OBSIDIAN_TREE_CONFIG);
    }
}
