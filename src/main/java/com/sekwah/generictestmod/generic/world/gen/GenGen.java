package com.sekwah.generictestmod.generic.world.gen;

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

import java.util.*;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class GenGen {

    public static void addFeatures() {
        getBiomes(HOT, OVERWORLD).forEach(biome -> biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                Blocks.OAK_LEAVES.getDefaultState(),
                                4 // deposit size
                        )
                ).withPlacement(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(/* Count, MinHeight, MaxHeightBase, MaxHeight */ 20, 30, 0, 128)
                ))
        ));


        getBiomes(HOT, OVERWORLD).forEach(biome -> biome.addFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                GenericFeatures.SOLID_FANCY_TREE_FEATURE.get().withConfiguration(GenericFeatures.OBSIDIAN_TREE_CONFIG)
                        .withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))
        )));
    }

    public static Set<Biome> getBiomes(BiomeDictionary.Type... biomeTypeArgs) {
        if (biomeTypeArgs.length == 0) {
            return Collections.emptySet();
        }
        List<BiomeDictionary.Type> biomeTypes = Arrays.asList(biomeTypeArgs);
        Iterator<BiomeDictionary.Type> it = biomeTypes.iterator();
        Set<Biome> biomes = BiomeDictionary.getBiomes(it.next());
        Set<Biome> filtering = new HashSet<Biome>(biomes);
        while(it.hasNext()) {
            biomes = BiomeDictionary.getBiomes(it.next());
            filtering.retainAll(biomes);
        }
        return filtering;
    }
}
