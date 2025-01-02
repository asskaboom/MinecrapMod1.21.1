package net.tony.minecrap.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.tony.minecrap.block.ModBlocks;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CONVEYOR_BELT_BLOCK)
                .add(ModBlocks.AMOGUS_ORE_BLOCK)
                .add(ModBlocks.AMOGUS_DEEPSLATE_ORE_BLOCK)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AMOGUS_ORE_BLOCK)
                .add(ModBlocks.AMOGUS_DEEPSLATE_ORE_BLOCK)
        ;
    }
}