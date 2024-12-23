package net.tony.minecrap.block;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.WallMountedBlock;
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
import net.tony.minecrap.block.custom.ConveyorBlock;

public class ModBlocks {

    //new blocks
    public static final Block CONVEYOR_BELT_BLOCK = registerBlock("conveyor_belt_block",
            new ConveyorBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()));

    public static final Block AMOGUS_ORE_BLOCK = registerBlock("amogus_ore_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()));
/*
    public static final Block TV_BLOCK = registerBlock("tv_block",
            new WallMountedBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()) {
                @Override
                protected MapCodec<? extends WallMountedBlock> getCodec() {
                    return null;
                }
            });
*/



    //methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Minecrap.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Minecrap.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }



    public static void registerModBlocks(){
        Minecrap.LOGGER.info("Registering Mod Blocks for " + Minecrap.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CONVEYOR_BELT_BLOCK);
            entries.add(ModBlocks.AMOGUS_ORE_BLOCK);
        });


    }
}
