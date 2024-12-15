package net.tony.minecrap.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class HookEntity extends PersistentProjectileEntity {

    private World world;
    private Entity hookedEntity;
    private boolean isPulling = false;
    private ItemStack stack;

    private double maxRange = 0D;
    private double maxSpeed = 0D;


    protected HookEntity(EntityType<? extends PersistentProjectileEntity> type, LivingEntity owner, World world, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(type, owner, world, stack, shotFrom);
        this.setNoGravity(true);
        this.setDamage(0);
        this.world = world;
    }

    @Override
    public void tick() {
        super.tick();

        if(getOwner() instanceof PlayerEntity owner) {
            if(isPulling && age % 2 == 0)
                world.playSound(null, getOwner().getBlockPos(), SoundEvents.ENTITY_DOLPHIN_JUMP, SoundCategory.PLAYERS, 1F, 1F);

            if(!world.isClient) {
                if(owner.isDead() || owner.distanceTo(this) > maxRange || !(owner.getMainHandStack().getItem() instanceof HookItem || owner.getOffHandStack().getItem() instanceof HookItem) )
                    kill();

                if(this.hookedEntity != null) {
                    if(this.hookedEntity.isRemoved()) {
                        this.hookedEntity = null;
                        onRemoved();
                    }
                }

                if(owner.getMainHandStack() == stack || owner.getOffHandStack() == stack) {
                    if(isPulling) {
                        Entity target = owner;
                        Entity origin = this;

                        if(owner.isSneaking() && hookedEntity != null) {
                            target = hookedEntity;
                            origin = owner;
                        }

                        double brakeZone = 6D;
                        double pullSpeed = maxSpeed / 6D;
                        Vec3d distance = origin.getPos().subtract(target.getPos().add(0, target.getHeight() / 2, 0));
                        Vec3d motion = distance.normalize().multiply(distance.length() < brakeZone ? (pullSpeed * distance.length()) / brakeZone : pullSpeed);

                        if(Math.abs(distance.y) < 0.1D)
                            motion = new Vec3d(motion.x, 0, motion.z);
                        if(new Vec3d(distance.x, 0, distance.z).length() < new Vec3d(target.getWidth() / 2, 0, target.getWidth() / 2).length() / 1.4)
                            motion = new Vec3d(0, motion.y, 0);

                        target.fallDistance = 0;
                        target.setVelocity(motion);
                        target.velocityModified = true;

                        if(owner.distanceTo(this) <= 3D)
                            kill();

                    }
                }
                else {
                    kill();
                }
            }
        }
        else {
            kill();
        }
    }


    @Override
    public boolean shouldRender(double distance) {
        return true;
    }



    @Override
    protected ItemStack asItemStack() {
        return ItemStack.EMPTY;
    }

    @Override
    public void kill() {
        if(!world.isClient && getOwner() instanceof PlayerEntity owner) {
            owner.setNoGravity(false);
        }
        super.kill();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        isPulling = true;

        if(!world.isClient && getOwner() instanceof PlayerEntity owner && hookedEntity == null){
            owner.setNoGravity(true);
        }

    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!world.isClient && getOwner() instanceof PlayerEntity owner && entityHitResult.getEntity() != owner) {
            if ((entityHitResult.getEntity() instanceof LivingEntity || entityHitResult.getEntity() instanceof EnderDragonPart) && hookedEntity == null) {
                hookedEntity = entityHitResult.getEntity();
                isPulling = true;
            }
        }
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return null;
    }


    public void setProperties(ItemStack stack, double maxRange, double maxVelocity, float pitch, float yaw, float roll, float modifierZ) {
        float f = 0.017453292F;
        float x = -MathHelper.sin(yaw * f) * MathHelper.cos(pitch * f);
        float y = -MathHelper.sin((pitch + roll) * f);
        float z = MathHelper.cos(yaw * f) * MathHelper.cos(pitch * f);
        this.setVelocity(x, y, z, modifierZ, 0);

        this.stack = stack;
        this.maxRange = maxRange;
        this.maxSpeed = maxVelocity;
    }
}