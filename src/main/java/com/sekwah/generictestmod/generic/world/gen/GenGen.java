package com.sekwah.generictestmod.generic.world.gen;

import com.sekwah.generictestmod.generic.world.biome.CustomFeatures;
import com.sekwah.generictestmod.generic.world.gen.feature.GenericFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class GenGen {

    public static void addFeatures() {
        getBiomes(HOT, OVERWORLD).forEach(biome -> biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configure(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                Blocks.OAK_LEAVES.getDefaultState(),
                                4 // deposit size
                        )
                ).createDecoratedFeature(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(/* Count, MinHeight, MaxHeightBase, MaxHeight */ 20, 30, 0, 128)
                ))
        ));


        getBiomes(HOT, OVERWORLD).forEach(biome -> biome.addFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                GenericFeatures.SOLID_FANCY_TREE_FEATURE.get().configure(CustomFeatures.OBSIDIAN_TREE_CONFIG)
                        .createDecoratedFeature(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))
        )));
    }

    public static Set<Biome> getBiomes(BiomeDictionary.Type type, BiomeDictionary.Type... filterTypes) {
        Set<Biome> biomes = BiomeDictionary.getBiomes(type);
        if(filterTypes.length == 0) {
            return biomes;
        }
        Set<Biome> filtering = new HashSet<Biome>();
        filtering.addAll(biomes);
        for (BiomeDictionary.Type fType:
                filterTypes) {
            Set<Biome> filterBiomes = BiomeDictionary.getBiomes(type);
            filtering.retainAll(filterBiomes);
        }
        return filtering;
    }
}
