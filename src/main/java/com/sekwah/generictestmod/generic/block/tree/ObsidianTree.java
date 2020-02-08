package com.sekwah.generictestmod.generic.block.tree;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class ObsidianTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> func_225546_b_(Random random, boolean b) {
        return random.nextInt(10) == 0 ? Feature.FANCY_TREE.withConfiguration(b ? DefaultBiomeFeatures.field_226817_l_ : DefaultBiomeFeatures.field_226815_j_) : Feature.NORMAL_TREE.withConfiguration(b ? DefaultBiomeFeatures.field_226816_k_ : DefaultBiomeFeatures.field_226739_a_);
    }
}
