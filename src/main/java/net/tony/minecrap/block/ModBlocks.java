package net.tony.minecrap.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.tony.minecrap.Minecrap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //new blocks
    public static final Block CONVEYOR_BELT_BLOCK = registerBlock("conveyor_belt_block.json",
            new Block(AbstractBlock.Settings.create()
                    .strength(1f)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Minecrap.MOD_ID,"conveyor_belt_block.json.json")))));



    //methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Minecrap.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Minecrap.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Minecrap.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }



    public static void registerModBlocks(){
        Minecrap.LOGGER.info("Registering Mod Blocks for " + Minecrap.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CONVEYOR_BELT_BLOCK);
        });


    }
}
