package net.tony.minecrap;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.tony.minecrap.block.ModBlocks;
import net.tony.minecrap.enchantment.ModEnchantmentEffects;
import net.tony.minecrap.item.ModItemGroups;
import net.tony.minecrap.item.ModItems;
import net.tony.minecrap.sound.ModSounds;
import net.tony.minecrap.util.ExcavatorUsageEvent;
import net.tony.minecrap.util.HammerUsageEvent;
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
		ModEnchantmentEffects.registerEnchantmentEffect();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register(new ExcavatorUsageEvent());
	}
}