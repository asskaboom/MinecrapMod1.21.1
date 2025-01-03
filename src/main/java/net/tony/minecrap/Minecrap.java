package net.tony.minecrap;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.TypedActionResult;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.sound.SoundCategory;
import net.tony.minecrap.block.ModBlocks;
import net.tony.minecrap.effect.ModEffects;
import net.tony.minecrap.enchantment.ModEnchantmentEffects;
import net.tony.minecrap.entity.ModEntities;
import net.tony.minecrap.entity.custom.AmogusEntity;
import net.tony.minecrap.item.ModItemGroups;
import net.tony.minecrap.item.ModItems;
import net.tony.minecrap.potion.ModPotions;
import net.tony.minecrap.sound.ModSounds;
import net.tony.minecrap.util.ExcavatorUsageEvent;
import net.tony.minecrap.util.HammerUsageEvent;
import net.tony.minecrap.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

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

		ModEntities.registerModEntities();

		ModWorldGeneration.generateModWorldGen();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register(new ExcavatorUsageEvent());

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.AMOGUS_INGOT, ModPotions.SUS_POTION);
		});

		UseItemCallback.EVENT.register((player, world, hand) -> {
			if (world.isClient()) {
				if (player.getStackInHand(hand).isOf(ModItems.DOUGH_SCEPTER)) {
					Random rand = new Random();
					float dough_random = rand.nextFloat(2);
					player.playSound(ModSounds.DOUGH_SCEPTER_USE, dough_random + 0.5F, dough_random);
					return TypedActionResult.success(player.getStackInHand(hand));
				}
				if (player.getStackInHand(hand).isOf(Items.DRAGON_HEAD)) {
					player.playSound(ModSounds.DRAGON_HEAD_SOUND, 1.0F, 1.0F);
					return TypedActionResult.success(player.getStackInHand(hand));
				}
			}
			return TypedActionResult.pass(player.getStackInHand(hand));
		});

		FabricDefaultAttributeRegistry.register(ModEntities.AMOGUS, AmogusEntity.createAttributes());
	}
}