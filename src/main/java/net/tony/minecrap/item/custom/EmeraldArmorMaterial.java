//package net.tony.minecrap.item.custom;
//import net.minecraft.entity.EquipmentSlot;
//import net.minecraft.item.ArmorMaterial;
//import net.minecraft.item.Items;
//import net.minecraft.recipe.Ingredient;
//import net.minecraft.sound.SoundEvent;
//import net.minecraft.sound.SoundEvents;
//
//public class EmeraldArmorMaterial implements ArmorMaterial {
//
//    private static final int DURABILITY_MULTIPLIER = 25;
//    private static final int[] PROTECTION_VALUES = {3, 6, 8, 3};
//    private static final int ENCHANTABILITY = 10;
//
//    @Override
//    public int getDurability(ArmorItem.Type type) {
//        return type.getMaxDamage(DURABILITY_MULTIPLIER);
//    }
//
//    @Override
//    public int getProtection(ArmorItem.Type type) {
//        return PROTECTION_VALUES[type.getEquipmentSlot().getEntitySlotId()];
//    }
//
//    @Override
//    public int getEnchantability() {
//        return ENCHANTABILITY;
//    }
//
//    @Override
//    public SoundEvent getEquipSound() {
//        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
//    }
//
//    @Override
//    public Ingredient getRepairIngredient() {
//        return Ingredient.ofItems(Items.EMERALD);
//    }
//
//    @Override
//    public String getName() {
//        return "emerald";
//    }
//
//    @Override
//    public float getToughness() {
//        return 2.0F;
//    }
//
//    @Override
//    public float getKnockbackResistance() {
//        return 0.0F;
//    }
//}