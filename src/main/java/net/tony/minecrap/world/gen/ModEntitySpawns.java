package net.tony.minecrap.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.tony.minecrap.entity.ModEntities;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.DESERT, BiomeKeys.CHERRY_GROVE, BiomeKeys.JUNGLE, BiomeKeys.THE_END, BiomeKeys.SWAMP, BiomeKeys.MUSHROOM_FIELDS, BiomeKeys.BEACH, BiomeKeys.PLAINS),
                SpawnGroup.CREATURE, ModEntities.AMOGUS, 15, 1, 4);

        SpawnRestriction.register(ModEntities.AMOGUS, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
