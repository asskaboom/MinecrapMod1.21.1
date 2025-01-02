package net.tony.minecrap.enchantment;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.tony.minecrap.Minecrap;
import net.tony.minecrap.enchantment.custom.NightVisionEnchantmentEffect;


public class ModEnchantments {

    public static final RegistryKey<Enchantment> NIGHT_VISION =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Minecrap.MOD_ID, "night_vision"));

    public static void bootstrap(Registerable<Enchantment> registerable){
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, NIGHT_VISION, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.HEAD_ARMOR),
                1, //proba in table
                1,
                Enchantment.leveledCost(2,1),
                Enchantment.leveledCost(5,1),
                2,
                AttributeModifierSlot.HEAD))
                        .addEffect(
                EnchantmentEffectComponentTypes.POST_ATTACK,
                EnchantmentEffectTarget.ATTACKER,
                EnchantmentEffectTarget.ATTACKER,
                new NightVisionEnchantmentEffect()));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}

