package net.tony.minecrap.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.tony.minecrap.Minecrap;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.jetbrains.annotations.Nullable;

public class ConveyorBlock extends HorizontalFacingBlock {
    private static final double beltSpeed = 1.5F;
    public static final MapCodec<ConveyorBlock> CODEC = Block.createCodec(ConveyorBlock::new);


    public ConveyorBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends ConveyorBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {


        if(entity instanceof LivingEntity){
            LivingEntity le = (LivingEntity)entity;
            if(!le.isSneaking()) {
                Direction direction = state.get(FACING);
                Vec3i vectorI = direction.getVector();
                Vec3d vector = new Vec3d(vectorI.getX(), vectorI.getY(), vectorI.getZ());
                moveEntityOn(vector, le);
            }
        }


        super.onSteppedOn(world, pos, state, entity);
    }

    public void moveEntityOn(Vec3d vector, LivingEntity livingEntity){
        vector = vector.multiply(beltSpeed);
        livingEntity.addVelocity(vector.getX(), vector.getY(), vector.getZ());
    }


}
