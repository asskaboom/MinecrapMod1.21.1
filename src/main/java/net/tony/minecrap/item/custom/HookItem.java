package net.tony.minecrap.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.tony.minecrap.sound.ModSounds;

import java.util.List;

public class HookItem extends Item {

    private double maxRange = 20;
    private double maxSpeed= 40;

    public HookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if(!world.isClient) {

                HookEntity hookshot = new HookEntity(EntityType.ARROW, user, world,stack,stack);
                hookshot.setProperties(stack, maxRange, maxSpeed, user.getPitch(), user.getYaw(), 0f, 1.5f * (float) (maxSpeed / 10));
                world.spawnEntity(hookshot);


            world.playSound(user, user.getBlockPos(), ModSounds.HOOK_USE, SoundCategory.PLAYERS, 1F, 1F);
        }
        return super.use(world, user, hand);
    }
}
