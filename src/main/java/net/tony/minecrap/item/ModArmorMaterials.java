package net.tony.minecrap.item;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
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
import java.util.Map;
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

    public static final RegistryEntry<ArmorMaterial> AMOGUS_ARMOR_MATERIAL = registerMaterial("amogus",
            // Defense (protection) point values for each armor piece.
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3
            ),
            // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
            5,
            // The sound played when the armor is equipped.
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            // The ingredient(s) used to repair the armor.
            () -> Ingredient.ofItems(ModItems.AMOGUS_INGOT),
            0.0F,
            0.0F,
            true);



    public static final RegistryEntry<ArmorMaterial> EMERALD_ARMOR_MATERIAL = registerMaterial("emerald",
            // Defense (protection) point values for each armor piece.
            Map.of(
                    ArmorItem.Type.HELMET, 2,
                    ArmorItem.Type.CHESTPLATE, 6,
                    ArmorItem.Type.LEGGINGS, 4,
                    ArmorItem.Type.BOOTS, 2
            ),
            // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
            5,
            // The sound played when the armor is equipped.
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            // The ingredient(s) used to repair the armor.
            () -> Ingredient.ofItems(Items.EMERALD),
            0.0F,
            0.0F,
            false);


    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        // Get the supported layers for the armor material
        List<ArmorMaterial.Layer> layers = List.of(
                // The ID of the texture layer, the suffix, and whether the layer is dyeable.
                // We can just pass the armor material ID as the texture layer ID.
                new ArmorMaterial.Layer(Identifier.of(Minecrap.MOD_ID, id), "", dyeable),
                new ArmorMaterial.Layer(Identifier.of(Minecrap.MOD_ID, id), "_overlay", false)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // Register the material within the ArmorMaterials registry.
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(Minecrap.MOD_ID, id), material);

        // The majority of the time, you'll want the RegistryEntry of the material - especially for the ArmorItem constructor.
        return RegistryEntry.of(material);
    }
}