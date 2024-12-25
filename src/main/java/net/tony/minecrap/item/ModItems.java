package net.tony.minecrap.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.tony.minecrap.item.ModArmorMaterials;
import net.tony.minecrap.Minecrap;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tony.minecrap.item.custom.HammerItem;
import net.tony.minecrap.item.custom.HookItem;
import net.tony.minecrap.item.custom.ModArmorItem;
import net.tony.minecrap.sound.ModSounds;

import java.util.List;


public class ModItems {
    //Items
    //public static final Item CONVEYOR_BELT = registerItem( "conveyor_belt_block.json");
    public static final Item TV = registerItem("tv", new Item(new Item.Settings()));
    public static final Item LEGACY_MUSIC_DISC = registerItem("legacy_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.LEGACY_KEY).maxCount(1)));
    
    public static final Item RAW_AMOGUS = registerItem("raw_amogus", new Item(new Item.Settings()));
    public static final Item AMOGUS_INGOT = registerItem("amogus_ingot", new Item(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.minecrap.amogus_ingot.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
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

    public static final Item AMOGUS_EXCAVATOR = registerItem("amogus_excavator",
            new HammerItem(ModToolMaterials.AMOGUS_INGOT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.AMOGUS_INGOT, 6, -2.4f))));

    public static final Item EMERALD_PICKAXE = registerItem("emerald_pickaxe",
            new PickaxeItem(ModToolMaterials.EMERALD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.EMERALD, 0, -2))));


    public static final Item EMERALD_HELMET = new ModArmorItem(
            ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
            new Item.Settings().maxCount(1));

    public static final Item EMERALD_CHESTPLATE = new ModArmorItem(
            ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxCount(1));

    public static final Item EMERALD_LEGGINGS = new ModArmorItem(
            ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxCount(1));

    public static final Item EMERALD_BOOTS = new ModArmorItem(
            ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
            new Item.Settings().maxCount(1));




    //Methods
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Minecrap.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Minecrap.LOGGER.info("Registering Mod Items for " + Minecrap.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_AMOGUS);
            entries.add(AMOGUS_INGOT);
        });


    }
}
