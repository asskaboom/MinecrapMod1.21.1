
package net.tony.minecrap.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

import net.minecraft.item.ArmorItem;
import net.tony.minecrap.block.ModBlocks;
import net.tony.minecrap.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMOGUS_ORE_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TV, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOOKSHOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMOGUS_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_AMOGUS, Models.GENERATED);
/*
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMOGUS_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMOGUS_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMOGUS_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMOGUS_BOOTS));

 */
    }
}
