package com.sekwah.generictestmod.generic.block.tree;

import com.sekwah.generictestmod.generic.world.gen.feature.GenericFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.Nullable;
import java.util.Random;

public class ObsidianTree extends Tree {


    /**
     * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of tree
     */
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.field_236291_c_.withConfiguration(GenericFeatures.OBSIDIAN_TREE_CONFIG);
    }

}
