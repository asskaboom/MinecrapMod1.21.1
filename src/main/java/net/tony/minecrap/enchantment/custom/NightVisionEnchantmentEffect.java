package net.tony.minecrap.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.tony.minecrap.Minecrap;


public record NightVisionEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<NightVisionEnchantmentEffect> CODEC = MapCodec.unit(NightVisionEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        Minecrap.LOGGER.info("Applying night vision....alegedlty");
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                serverPlayerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200));
                Minecrap.LOGGER.info("Applying night vision....alegedlty");
            }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
