package com.sekwah.generictestmod.generic.world.gen;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;

public class GenGen {

    public static void init() {
        BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST).forEach(biome -> biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configure(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                Blocks.OAK_LEAVES.getDefaultState(),
                                17 // deposit size
                        )
                ).createDecoratedFeature(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(/* Count, MinHeight, MaxHeightBase, MaxHeight */ 100, 0, 0, 128)
                ))
        ));
    }
}
