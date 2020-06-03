package com.sekwah.generictestmod.generic.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.FancyTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class SolidFancyTreeFeature extends FancyTreeFeature {
    public SolidFancyTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> p_i225803_1_) {
        super(p_i225803_1_);
    }
    
    public int makeBranch(IWorldGenerationReader worldGenerationReader, Random random, BlockPos blockPos, BlockPos blockPos2, boolean p_227235_5_, Set<BlockPos> blockPosSet, MutableBoundingBox boundingBox, TreeFeatureConfig treeFeatureConfig) {
        if (!p_227235_5_ && Objects.equals(blockPos, blockPos2)) {
            return -1;
        } else {
            BlockPos lvt_9_1_ = blockPos2.add(-blockPos.getX(), -blockPos.getY(), -blockPos.getZ());
            int lvt_10_1_ = this.getLongestSide(lvt_9_1_);
            float lvt_11_1_ = (float)lvt_9_1_.getX() / (float)lvt_10_1_;
            float lvt_12_1_ = (float)lvt_9_1_.getY() / (float)lvt_10_1_;
            float lvt_13_1_ = (float)lvt_9_1_.getZ() / (float)lvt_10_1_;

            for(int lvt_14_1_ = 0; lvt_14_1_ <= lvt_10_1_; ++lvt_14_1_) {
                BlockPos lvt_15_1_ = blockPos.add((double)(0.5F + (float)lvt_14_1_ * lvt_11_1_), (double)(0.5F + (float)lvt_14_1_ * lvt_12_1_), (double)(0.5F + (float)lvt_14_1_ * lvt_13_1_));
                if (p_227235_5_) {
                    this.setBlockState(worldGenerationReader, lvt_15_1_, treeFeatureConfig.trunkProvider.getBlockState(random, lvt_15_1_));
                    blockPosSet.add(lvt_15_1_);
                } else if (!isAir(worldGenerationReader, lvt_15_1_)) {
                    return lvt_14_1_;
                }
            }

            return -1;
        }
    }

    private int getLongestSide(BlockPos p_227237_1_) {
        int lvt_2_1_ = MathHelper.abs(p_227237_1_.getX());
        int lvt_3_1_ = MathHelper.abs(p_227237_1_.getY());
        int lvt_4_1_ = MathHelper.abs(p_227237_1_.getZ());
        if (lvt_4_1_ > lvt_2_1_ && lvt_4_1_ > lvt_3_1_) {
            return lvt_4_1_;
        } else {
            return lvt_3_1_ > lvt_2_1_ ? lvt_3_1_ : lvt_2_1_;
        }
    }
}
