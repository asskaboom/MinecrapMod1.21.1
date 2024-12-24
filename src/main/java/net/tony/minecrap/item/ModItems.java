package net.tony.minecrap.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tony.minecrap.Minecrap;
import net.tony.minecrap.item.custom.HammerItem;
import net.tony.minecrap.item.custom.HookItem;
import net.tony.minecrap.item.custom.ModArmorItem;
import net.tony.minecrap.item.ModArmorMaterials;
import net.tony.minecrap.sound.ModSounds;

import java.util.List;
import java.util.Map;

public class ModItems {
    // Non-Emerald Items: Left exactly as they were
    public static final Item TV = registerItem("tv", new Item(new Item.Settings()));
    public static final Item LEGACY_MUSIC_DISC = registerItem("legacy_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.LEGACY_KEY).maxCount(1)));

    public static final Item RAW_AMOGUS = registerItem("raw_amogus", new Item(new Item.Settings()));
    public static final Item AMOGUS_INGOT = registerItem("amogus_ingot", new Item(new Item.Settings(){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.minecrap.amogus_ingot.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }));
    public static final Item HOOKSHOT = registerItem("hook", new HookItem(new Item.Settings()));

    public static final Item AMOGUS_HELMET = registerItem("amogus_helmet",
            new ModArmorItem(ModArmorMaterials.AMOGUS_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(30))));
    public static final Item AMOGUS_CHESTPLATE = registerItem("amogus_chestplate",
            new ArmorItem(ModArmorMaterials.AMOGUS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(30))));
    public static final Item AMOGUS_LEGGINGS = registerItem("amogus_leggings",
            new ArmorItem(ModArmorMaterials.AMOGUS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(30))));
    public static final Item AMOGUS_BOOTS= registerItem("amogus_boots",
            new ArmorItem(ModArmorMaterials.AMOGUS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(30))));

    public static final Item AMOGUS_HAMMER = registerItem("amogus_hammer",
            new HammerItem(ModToolMaterials.AMOGUS_INGOT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.AMOGUS_INGOT, 7, -3.4f))));

    // Fix for Emerald Armor Material ------------------------------------------------------------------------------
    public static final RegistryEntry<ArmorMaterial> EMERALD_ARMOR_MATERIAL_ENTRY = Registry.register(
            Registries.ARMOR_MATERIAL,
            new Identifier("minecrap", "emerald"),
            new ArmorMaterial(
                    Map.of(
                            ArmorItem.Type.HELMET, 11,
                            ArmorItem.Type.CHESTPLATE, 16,
                            ArmorItem.Type.LEGGINGS, 15,
                            ArmorItem.Type.BOOTS, 13
                    ), // Durabilities
                    25, // Enchantability
                    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, // Equip sound
                    () -> Ingredient.ofItems(Items.EMERALD), // Repair ingredient
                    List.of(), // Layers
                    2.0f, // Toughness
                    0.0f  // Knockback resistance
            )
    );

    // Fixed Emerald Items to Use EMERALD_ARMOR_MATERIAL_ENTRY ----------------------------------------------------
    public static final Item EMERALD_PICKAXE = registerItem("emerald_pickaxe",
            new PickaxeItem(ModToolMaterials.EMERALD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.EMERALD, 0, -2))));

    public static final Item EMERALD_HELMET = registerItem("emerald_helmet",
            new ArmorItem(EMERALD_ARMOR_MATERIAL_ENTRY, ArmorItem.Type.HELMET, new Item.Settings()));

    public static final Item EMERALD_CHESTPLATE = registerItem("emerald_chestplate",
            new ArmorItem(EMERALD_ARMOR_MATERIAL_ENTRY, ArmorItem.Type.CHESTPLATE, new Item.Settings()));

    public static final Item EMERALD_LEGGINGS = registerItem("emerald_leggings",
            new ArmorItem(EMERALD_ARMOR_MATERIAL_ENTRY, ArmorItem.Type.LEGGINGS, new Item.Settings()));

    public static final Item EMERALD_BOOTS = registerItem("emerald_boots",
            new ArmorItem(EMERALD_ARMOR_MATERIAL_ENTRY, ArmorItem.Type.BOOTS, new Item.Settings()));

    // Register Items Method --------------------------------------------------------------------------------------
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Minecrap.MOD_ID, name), item);
    }

    // Add Items to Item Groups -----------------------------------------------------------------------------------
    public static void addItemsToItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(EMERALD_HELMET);
            entries.add(EMERALD_CHESTPLATE);
            entries.add(EMERALD_LEGGINGS);
            entries.add(EMERALD_BOOTS);
        });
    }

    // Register Mod Items -----------------------------------------------------------------------------------------
    public static void registerModItems() {
        Minecrap.LOGGER.info("Registering Mod Items for " + Minecrap.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_AMOGUS);
            entries.add(AMOGUS_INGOT);
            entries.add(EMERALD_PICKAXE);
        });
    }
}