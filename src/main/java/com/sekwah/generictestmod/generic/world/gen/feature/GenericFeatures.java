package com.sekwah.generictestmod.generic.world.gen.feature;

import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.FancyTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sekwah.generictestmod.GenericConstants.MOD_ID;

public class GenericFeatures {

    private static final DeferredRegister<Feature<?>> FEATURE_REGISTER = new DeferredRegister<>(ForgeRegistries.FEATURES, MOD_ID);

    public static RegistryObject<SolidFancyTreeFeature> SOLID_FANCY_TREE_FEATURE = FEATURE_REGISTER.register("solid_fancy_tree",
            () -> new SolidFancyTreeFeature(TreeFeatureConfig::deserializeFoliage));


    public static void register(IEventBus eventBus) {
        FEATURE_REGISTER.register(eventBus);
    }
}
