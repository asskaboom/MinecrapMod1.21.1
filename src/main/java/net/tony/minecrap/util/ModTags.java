package net.tony.minecrap.util;

import net.tony.minecrap.Minecrap;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_FOR_AMOGUS_INGOT_TOOL = createTag("needs_for_amogus_ingot_tool");
        public static final TagKey<Block> INCORRECT_FOR_AMOGUS_INGOT_TOOL = createTag("incorrect_for_amogus_ingot_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Minecrap.MOD_ID, name));
        }
    }

    public static class Items {
        //public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");



        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Minecrap.MOD_ID, name));
        }
    }
}