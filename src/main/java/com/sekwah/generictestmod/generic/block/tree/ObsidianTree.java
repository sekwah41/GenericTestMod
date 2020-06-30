//package com.sekwah.generictestmod.generic.block.tree;
//
//import com.mojang.serialization.Codec;
//import com.mojang.serialization.codecs.RecordCodecBuilder;
//import com.sekwah.generictestmod.generic.world.biome.CustomFeatures;
//import com.sekwah.generictestmod.generic.world.gen.feature.GenericFeatures;
//import net.minecraft.block.trees.Tree;
//import net.minecraft.world.gen.Heightmap;
//import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
//import net.minecraft.world.gen.feature.AbstractFeatureSizeType;
//import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
//import net.minecraft.world.gen.feature.ConfiguredFeature;
//import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
//import net.minecraft.world.gen.treedecorator.TreeDecorator;
//import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
//
//import javax.annotation.Nullable;
//import java.util.Random;
//
//public class ObsidianTree extends Tree {
//
//    public static final Codec<BaseTreeFeatureConfig> field_236676_a_ = RecordCodecBuilder.create((p_236683_0_) -> {
//        return p_236683_0_.group(BlockStateProvider.field_236796_a_.fieldOf("trunk_provider").forGetter((p_236693_0_) -> {
//            return p_236693_0_.trunkProvider;
//        }), BlockStateProvider.field_236796_a_.fieldOf("leaves_provider").forGetter((p_236692_0_) -> {
//            return p_236692_0_.leavesProvider;
//        }), FoliagePlacer.field_236749_d_.fieldOf("foliage_placer").forGetter((p_236691_0_) -> {
//            return p_236691_0_.field_236677_f_;
//        }), AbstractTrunkPlacer.field_236905_c_.fieldOf("trunk_placer").forGetter((p_236690_0_) -> {
//            return p_236690_0_.field_236678_g_;
//        }), AbstractFeatureSizeType.field_236704_a_.fieldOf("minimum_size").forGetter((p_236689_0_) -> {
//            return p_236689_0_.field_236679_h_;
//        }), TreeDecorator.field_236874_c_.listOf().fieldOf("decorators").forGetter((p_236688_0_) -> {
//            return p_236688_0_.decorators;
//        }), Codec.INT.fieldOf("max_water_depth").withDefault(0).forGetter((p_236687_0_) -> {
//            return p_236687_0_.field_236680_i_;
//        }), Codec.BOOL.fieldOf("ignore_vines").withDefault(false).forGetter((p_236686_0_) -> {
//            return p_236686_0_.field_236681_j_;
//        }), Heightmap.Type.field_236078_g_.fieldOf("heightmap").forGetter((p_236684_0_) -> {
//            return p_236684_0_.field_236682_l_;
//        })).apply(p_236683_0_, BaseTreeFeatureConfig::new);
//    });
//
//    @Nullable
//    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random rand, boolean switcharoo) {
//        return GenericFeatures.SOLID_FANCY_TREE_FEATURE.get().makeBranch(/*DefaultBiomeFeatures.BIRCH_TREE_CONFIG*/CustomFeatures.OBSIDIAN_TREE_CONFIG);
//    }
//}
