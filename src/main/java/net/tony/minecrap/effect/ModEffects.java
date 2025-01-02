package net.tony.minecrap.effect;

import net.tony.minecrap.Minecrap;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> DIARRHEA = registerStatusEffect("diarrhea",
            new DiarrheaEffect(StatusEffectCategory.NEUTRAL, 0xFFFFFF));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Minecrap.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Minecrap.LOGGER.info("Registering Mod Effects for " + Minecrap.MOD_ID);
    }
}