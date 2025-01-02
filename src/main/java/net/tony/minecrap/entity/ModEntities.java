package net.tony.minecrap.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tony.minecrap.Minecrap;
import net.tony.minecrap.entity.custom.AmogusEntity;

public class ModEntities {

    public static final EntityType<AmogusEntity> AMOGUS = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Minecrap.MOD_ID, "amogus"),
            EntityType.Builder.create(AmogusEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 1f).build());


    public static void registerModEntities() {
        Minecrap.LOGGER.info("Registering Mod Entities for " + Minecrap.MOD_ID);
    }

}
