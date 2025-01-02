package net.tony.minecrap.world.gen;

public class ModWorldGeneration {

    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModEntitySpawns.addSpawns();
    }
}
