package net.tony.minecrap;

import net.fabricmc.api.ModInitializer;

import net.tony.minecrap.block.ModBlocks;
import net.tony.minecrap.item.ModItemGroups;
import net.tony.minecrap.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minecrap implements ModInitializer {
	public static final String MOD_ID = "minecrap";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}