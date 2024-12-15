package net.tony.minecrap.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tony.minecrap.Minecrap;

public class ModItemGroups {
    /*
    //Groups
    public static final ItemGroup SHMOOVE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Minecrap.MOD_ID, "shmoove_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModItems.CONVEYOR_BELT))
                    .displayName(Text.translatable("itemgroup.minecrap.shmoove_items"))
                    .entries((displayContext, entries) -> {
                        //add items to group
                        entries.add(ModItems.CONVEYOR_BELT);
                    }).build());
    */

    public static final ItemGroup MEMES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Minecrap.MOD_ID, "meme_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModItems.TV))
                    .displayName(Text.translatable("itemgroup.minecrap.meme_items"))
                    .entries((displayContext, entries) -> {
                        //add items to group
                        entries.add(ModItems.TV);
                    }).build());



    //Methods
    public static void registerItemGroups(){
        Minecrap.LOGGER.info("Registering Item Groups for " + Minecrap.MOD_ID);
    }
}
