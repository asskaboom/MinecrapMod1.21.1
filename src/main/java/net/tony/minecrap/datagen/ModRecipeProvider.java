package net.tony.minecrap.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.item.Items;
import net.tony.minecrap.Minecrap;
import net.tony.minecrap.block.ModBlocks;
import net.tony.minecrap.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> AMOGUS_INGOT_SMELTABLES = List.of(ModItems.RAW_AMOGUS, ModBlocks.AMOGUS_ORE_BLOCK);

        offerSmelting(exporter, AMOGUS_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.AMOGUS_INGOT, 0.25f, 200, "pink_garnet");
        offerBlasting(exporter, AMOGUS_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.AMOGUS_INGOT, 0.25f, 100, "pink_garnet");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMOGUS_HELMET)
                .pattern("AAA")
                .pattern("A A")
                .input('A', ModItems.AMOGUS_INGOT)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMOGUS_CHESTPLATE)
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ModItems.AMOGUS_INGOT)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMOGUS_LEGGINGS)
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .input('A', ModItems.AMOGUS_INGOT)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMOGUS_BOOTS)
                .pattern("A A")
                .pattern("A A")
                .input('A', ModItems.AMOGUS_INGOT)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .offerTo(exporter);

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMOGUS_HAMMER)
                .pattern("AAA")
                .pattern("ASA")
                .pattern(" S ")
                .input('A', ModItems.AMOGUS_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

              ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMOGUS_EXCAVATOR)
                .pattern(" A ")
                .pattern("ASA")
                .pattern(" S ")
                .input('A', ModItems.AMOGUS_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HOOKSHOT)
                .pattern("AA ")
                .pattern("AS ")
                .pattern("  H")
                .input('A', ModItems.AMOGUS_INGOT)
                .input('S', Items.STRING)
                .input('H', Items.STICK)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TV)
                .pattern("AAA")
                .pattern("ATA")
                .pattern("AAA")
                .input('A', ModItems.AMOGUS_INGOT)
                .input('T', Items.TORCH)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .criterion(hasItem(Items.TORCH), conditionsFromItem(Items.TORCH))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEGACY_MUSIC_DISC)
                .pattern(" S ")
                .pattern("SAS")
                .pattern(" S ")
                .input('A', ModItems.AMOGUS_INGOT)
                .input('S', Items.STONE)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FART_MUSIC_DISC, 1)
                .pattern("SSS")
                .pattern("SDS")
                .pattern("SSS")
                .input('D', ModItems.LEGACY_MUSIC_DISC)
                .input('S', ModItems.SHIT)
                .criterion(hasItem(ModItems.LEGACY_MUSIC_DISC), conditionsFromItem(ModItems.LEGACY_MUSIC_DISC))
                .criterion(hasItem(ModItems.SHIT), conditionsFromItem(ModItems.SHIT))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_SHOVEL)
                .pattern("E")
                .pattern("S")
                .pattern("S")
                .input('S', Items.STICK)
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_AXE)
                .pattern("EE")
                .pattern("ES")
                .pattern(" S")
                .input('S', Items.STICK)
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_HOE)
                .pattern("EE")
                .pattern(" S")
                .pattern(" S")
                .input('S', Items.STICK)
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_SWORD)
                .pattern("E")
                .pattern("E")
                .pattern("S")
                .input('S', Items.STICK)
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_HELMET)
                .pattern("EEE")
                .pattern("E E")
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_CHESTPLATE)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_LEGGINGS)
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_BOOTS)
                .pattern("E E")
                .pattern("E E")
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

      
        /*
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_pink_garnet_from_magic_block"));
        */

    }
}