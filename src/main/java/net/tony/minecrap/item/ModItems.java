package net.tony.minecrap.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.tony.minecrap.Minecrap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tony.minecrap.item.custom.HookItem;

import java.util.List;


public class ModItems {
    //Items
    //public static final Item CONVEYOR_BELT = registerItem( "conveyor_belt_block.json");
    public static final Item TV = registerItem("tv", new Item(new Item.Settings()));
    public static final Item RAW_AMOGUS = registerItem("raw_amogus", new Item(new Item.Settings()));
    public static final Item AMOGUS_INGOT = registerItem("amogus_ingot", new Item(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.minecrap.amogus_ingot.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item HOOKSHOT = registerItem("hook", new HookItem(new Item.Settings()));

    //Methods
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Minecrap.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Minecrap.LOGGER.info("Registering Mod Items for " + Minecrap.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_AMOGUS);
            entries.add(AMOGUS_INGOT);
        });


    }
}
