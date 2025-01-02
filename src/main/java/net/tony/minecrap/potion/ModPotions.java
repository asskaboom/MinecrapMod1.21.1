package net.tony.minecrap.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.tony.minecrap.Minecrap;
import net.tony.minecrap.effect.ModEffects;

public class ModPotions {

    public static final RegistryEntry<Potion> SUS_POTION = registerPotion("sus_potion",
            new Potion(new StatusEffectInstance(ModEffects.DIARRHEA, 1000, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(Minecrap.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        Minecrap.LOGGER.info("Registering Mod Potions for " + Minecrap.MOD_ID);
    }
}
