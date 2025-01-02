package net.tony.minecrap.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tony.minecrap.Minecrap;
import net.tony.minecrap.enchantment.custom.NightVisionEnchantmentEffect;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> NIGHT_VISION =
            registerEntityEffect("night_vision", NightVisionEnchantmentEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Minecrap.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        Minecrap.LOGGER.info("Registering Mod Enchantment Effects for " + Minecrap.MOD_ID);
    }
}
