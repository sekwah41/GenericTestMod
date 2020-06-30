package com.sekwah.generictestmod.generic.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sekwah.generictestmod.GenericConstants.MOD_ID;

public class GenericBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

//    public static final RegistryObject<Block> OBSIDIAN_TREE = BLOCKS.register("obsidian_sapling",
//            () -> new GenericSaplingBlock(new ObsidianTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));

//    public static final RegistryObject<Item> ITEM_OBSIDIAN_TREE = BLOCK_ITEMS.register("obsidian_sapling",
//            () -> new BlockItem(OBSIDIAN_TREE.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
    }
}
