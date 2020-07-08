package com.sekwah.generictestmod.generic.world.gen.feature;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sekwah.generictestmod.GenericConstants.MOD_ID;

public class GenericFeatures {

    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MOD_ID);

    public static final BaseTreeFeatureConfig OBSIDIAN_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.CRYING_OBSIDIAN.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.DIAMOND_ORE.getDefaultState()),
            new BlobFoliagePlacer(2, 0, 0, 0, 3),
            new StraightTrunkPlacer(5, 2, 0),
            new TwoLayerFeature(1, 0, 1)).func_236700_a_()
    ).build();

    public static RegistryObject<TreeFeature> SOLID_FANCY_TREE_FEATURE = FEATURES.register("obsidian_tree",
            () -> new TreeFeature(BaseTreeFeatureConfig.field_236676_a_));


    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
