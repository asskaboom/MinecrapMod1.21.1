package net.tony.minecrap;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.TypedActionResult;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.tony.minecrap.block.ModBlocks;
import net.tony.minecrap.effect.ModEffects;
import net.tony.minecrap.enchantment.ModEnchantmentEffects;
import net.tony.minecrap.item.ModItemGroups;
import net.tony.minecrap.item.ModItems;
import net.tony.minecrap.potion.ModPotions;
import net.tony.minecrap.sound.ModSounds;
import net.tony.minecrap.util.ExcavatorUsageEvent;
import net.tony.minecrap.util.HammerUsageEvent;
import net.tony.minecrap.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minecrap implements ModInitializer {
	public static final String MOD_ID = "minecrap";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModSounds.registerSounds();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEnchantmentEffects.registerEnchantmentEffects();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModWorldGeneration.generateModWorldGen();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register(new ExcavatorUsageEvent());


		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.AMOGUS_INGOT, ModPotions.SUS_POTION);
		});


		UseItemCallback.EVENT.register((player, world, hand) -> {
			if (world.isClient()) {
				if (player.getStackInHand(hand).isOf(ModItems.DOUGH_SCEPTER)) {
					player.playSound(ModSounds.DOUGH_SCEPTER_USE, 1.0F, 1.0F);
					return TypedActionResult.success(player.getStackInHand(hand));
				}
			}
			return TypedActionResult.pass(player.getStackInHand(hand));
		});


	}
}