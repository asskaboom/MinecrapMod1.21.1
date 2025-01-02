package net.tony.minecrap.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tony.minecrap.item.ModItems;
import net.tony.minecrap.sound.ModSounds;

import java.util.Random;

public class DiarrheaEffect extends StatusEffect {
    public DiarrheaEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

        Random rand = new Random();
        //runs every tick, odds of getting one in 10 seconds
        int odds = rand.nextInt(200);
        if (odds == 69){
            World world = entity.getWorld();
            BlockPos pos = entity.getBlockPos();
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();
            float fart_mix = rand.nextFloat(2);
            world.playSound(null, entity.getBlockPos(), ModSounds.SHART, SoundCategory.PLAYERS, fart_mix + 0.5f, fart_mix);
            //world.createExplosion(entity, x, y, z,0.1f, World.ExplosionSourceType.NONE );
            ItemEntity shit = new ItemEntity(world, x, y, z, new ItemStack(ModItems.SHIT,1));
            world.spawnEntity(shit);
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}

