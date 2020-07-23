package com.sekwah.generictestmod.generic.items;

import com.sekwah.generictestmod.GenericConstants;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sekwah.generictestmod.GenericConstants.MOD_ID;

public class GenericItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
