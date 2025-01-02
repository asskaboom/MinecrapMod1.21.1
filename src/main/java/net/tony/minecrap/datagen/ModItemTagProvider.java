package net.tony.minecrap.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.tag.ItemTags;
import net.tony.minecrap.item.ModItems;
import net.tony.minecrap.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.AMOGUS_HELMET)
                .add(ModItems.AMOGUS_CHESTPLATE)
                .add(ModItems.AMOGUS_LEGGINGS)
                .add(ModItems.AMOGUS_BOOTS);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.AMOGUS_HELMET)
                .add(ModItems.AMOGUS_CHESTPLATE)
                .add(ModItems.AMOGUS_LEGGINGS)
                .add(ModItems.AMOGUS_BOOTS);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ModItems.AMOGUS_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ModItems.AMOGUS_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ModItems.AMOGUS_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ModItems.AMOGUS_BOOTS);

        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.AMOGUS_HAMMER);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE).add(ModItems.AMOGUS_HAMMER);
        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModItems.AMOGUS_HAMMER);


        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.AMOGUS_EXCAVATOR);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ModItems.AMOGUS_EXCAVATOR);

        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.EMERALD_PICKAXE);
        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModItems.EMERALD_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.EMERALD_SHOVEL);
        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModItems.EMERALD_SHOVEL);

        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.EMERALD_AXE);
        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModItems.EMERALD_AXE);

        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.EMERALD_HOE);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ModItems.EMERALD_HOE);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.EMERALD_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(ModItems.EMERALD_SWORD);
        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModItems.EMERALD_SWORD);

        getOrCreateTagBuilder(ItemTags.DYEABLE)
                .add(ModItems.AMOGUS_HELMET)
                .add(ModItems.AMOGUS_CHESTPLATE)
                .add(ModItems.AMOGUS_LEGGINGS)
                .add(ModItems.AMOGUS_BOOTS);

    }
}