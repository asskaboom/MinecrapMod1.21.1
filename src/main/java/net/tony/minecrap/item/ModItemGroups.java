package net.tony.minecrap.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tony.minecrap.Minecrap;
import net.tony.minecrap.block.ModBlocks;

public class ModItemGroups {
    //Groups
    public static final ItemGroup SHMOOVE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Minecrap.MOD_ID, "shmoove_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModBlocks.CONVEYOR_BELT_BLOCK))
                    .displayName(Text.translatable("itemgroup.minecrap.shmoove_items"))
                    .entries((displayContext, entries) -> {
                        //add items to group
                        entries.add(ModBlocks.CONVEYOR_BELT_BLOCK);
                        //entries.add(ModBlocks.TV_BLOCK);
                    }).build());

    public static final ItemGroup AMOGUS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Minecrap.MOD_ID, "amogus_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModItems.AMOGUS_INGOT))
                    .displayName(Text.translatable("itemgroup.minecrap.amogus_items"))
                    .entries((displayContext, entries) -> {
                        //add items to group
                        entries.add(ModItems.AMOGUS_HELMET);
                        entries.add(ModItems.AMOGUS_CHESTPLATE);
                        entries.add(ModItems.AMOGUS_LEGGINGS);
                        entries.add(ModItems.AMOGUS_BOOTS);

                        entries.add(ModItems.AMOGUS_INGOT);
                        entries.add(ModItems.RAW_AMOGUS);

                        entries.add(ModItems.AMOGUS_HAMMER);
                        entries.add(ModItems.AMOGUS_EXCAVATOR);

                        entries.add(ModItems.AMOGUS_SPAWN_EGG);
                        entries.add(ModItems.SPACE_PART);
                        entries.add(ModItems.WINGS);


                    }).build());

    public static final ItemGroup MEMES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Minecrap.MOD_ID, "meme_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModItems.TV))
                    .displayName(Text.translatable("itemgroup.minecrap.meme_items"))
                    .entries((displayContext, entries) -> {
                        //add items to group
                        entries.add(ModItems.HOOKSHOT);
                        entries.add(ModItems.SHIT);
                        entries.add(ModItems.LEGACY_MUSIC_DISC);
                        entries.add(ModItems.TV);
                        entries.add(ModItems.FART_MUSIC_DISC);

                        entries.add(ModItems.DOUGH_SCEPTER);
                        entries.add(ModItems.CROWN);

                    }).build());

    public static final ItemGroup EMERALD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Minecrap.MOD_ID, "emerald_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(Items.EMERALD))
                    .displayName(Text.translatable("itemgroup.minecrap.emerald_items"))
                    .entries((displayContext, entries) -> {
                        //add items to group
                        entries.add(ModItems.EMERALD_PICKAXE);
                        entries.add(ModItems.EMERALD_SHOVEL);
                        entries.add(ModItems.EMERALD_AXE);
                        entries.add(ModItems.EMERALD_HOE);
                        entries.add(ModItems.EMERALD_SWORD);

                        entries.add(ModItems.EMERALD_HELMET);
                        entries.add(ModItems.EMERALD_CHESTPLATE);
                        entries.add(ModItems.EMERALD_LEGGINGS);
                        entries.add(ModItems.EMERALD_BOOTS);
                    }).build());



    //Methods
    public static void registerItemGroups(){
        Minecrap.LOGGER.info("Registering Item Groups for " + Minecrap.MOD_ID);
    }
}
