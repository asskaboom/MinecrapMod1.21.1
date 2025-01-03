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

        offerSmelting(exporter, AMOGUS_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.AMOGUS_INGOT, 0.25f, 200, "amogus");
        offerBlasting(exporter, AMOGUS_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.AMOGUS_INGOT, 0.25f, 100, "amogus");

        List<ItemConvertible> SPACE_PART_SMELTABLE = List.of(ModItems.SPACE_PART);

        offerSmelting(exporter, SPACE_PART_SMELTABLE, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 200, "amogus");
        offerBlasting(exporter, SPACE_PART_SMELTABLE, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 100, "amogus");

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
                .input('S', ModItems.SPACE_PART)
                .input('H', Items.STICK)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .criterion(hasItem(ModItems.SPACE_PART), conditionsFromItem(ModItems.SPACE_PART))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONVEYOR_BELT_BLOCK, 9)
                .pattern("AAA")
                .pattern("AIA")
                .pattern("AAA")
                .input('A', ModItems.AMOGUS_INGOT)
                .input('I', Items.IRON_BLOCK)
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BONE_MEAL, 1)
                .input(ModItems.SHIT)
                .criterion(hasItem(ModItems.SHIT), conditionsFromItem(ModItems.SHIT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COAL, 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.SHIT)
                .criterion(hasItem(ModItems.SHIT), conditionsFromItem(ModItems.SHIT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMOGUS_SPAWN_EGG, 2)
                .pattern("STS")
                .pattern("IFI")
                .pattern("CBC")
                .input('F', ModItems.FART_MUSIC_DISC)
                .input('S', ModItems.SHIT)
                .input('I', ModItems.AMOGUS_INGOT)
                .input('C', ModBlocks.CONVEYOR_BELT_BLOCK)
                .input('B', Items.DIAMOND_BLOCK)
                .input('T', ModItems.TV)
                .criterion(hasItem(ModItems.FART_MUSIC_DISC), conditionsFromItem(ModItems.FART_MUSIC_DISC))
                .criterion(hasItem(ModItems.SHIT), conditionsFromItem(ModItems.SHIT))
                .criterion(hasItem(ModItems.AMOGUS_INGOT), conditionsFromItem(ModItems.AMOGUS_INGOT))
                .criterion(hasItem(ModBlocks.CONVEYOR_BELT_BLOCK), conditionsFromItem(ModBlocks.CONVEYOR_BELT_BLOCK))
                .criterion(hasItem(Items.DIAMOND_BLOCK), conditionsFromItem(Items.DIAMOND_BLOCK))
                .criterion(hasItem(ModItems.TV), conditionsFromItem(ModItems.TV))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WINGS, 2)
                .pattern("PPP")
                .pattern("PEP")
                .pattern("PPP")
                .input('P', ModItems.SPACE_PART)
                .input('E', Items.ELYTRA)
                .criterion(hasItem(ModItems.SPACE_PART), conditionsFromItem(ModItems.SPACE_PART))
                .criterion(hasItem(Items.ELYTRA), conditionsFromItem(Items.ELYTRA))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ELYTRA, 1)
                .input(ModItems.WINGS)
                .criterion(hasItem(ModItems.WINGS), conditionsFromItem(ModItems.WINGS))
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOUGH_SCEPTER)
                .pattern("SB")
                .pattern("SB")
                .pattern("S ")
                .input('B', Items.BREAD)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CROWN)
                .pattern("DGD")
                .pattern("G G")
                .pattern("   ")
                .input('D', Items.DIAMOND)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);


        /*
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_pink_garnet_from_magic_block"));
        */

    }
}