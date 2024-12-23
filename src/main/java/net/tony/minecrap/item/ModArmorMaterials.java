package net.tony.minecrap.item;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.tony.minecrap.Minecrap;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.tony.minecrap.item.ModItems;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    /*public static final RegistryEntry<ArmorMaterial> AMOGUS_ARMOR_MATERIAL = registerArmorMaterial("amogus",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.AMOGUS_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Minecrap.MOD_ID, "amogus"),"_overlay",true)),0,0));

    */

    public static final RegistryEntry<ArmorMaterial> AMOGUS_ARMOR_MATERIAL = registerArmorMaterial("amogus",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.AMOGUS_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Minecrap.MOD_ID, "amogus"),"_overlay",true)),0,0));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Minecrap.MOD_ID, name), material.get());
    }
}