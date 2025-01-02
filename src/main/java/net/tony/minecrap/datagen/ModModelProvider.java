
package net.tony.minecrap.datagen;

import com.ibm.icu.text.Normalizer2;
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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMOGUS_DEEPSLATE_ORE_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TV, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOOKSHOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHIT, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMOGUS_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_AMOGUS, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMOGUS_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMOGUS_EXCAVATOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_SWORD, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERALD_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERALD_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERALD_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERALD_BOOTS);

        itemModelGenerator.register(ModItems.LEGACY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.FART_MUSIC_DISC, Models.GENERATED);

    }
}
