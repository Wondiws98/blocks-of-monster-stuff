package net.wondiws98.blocksofmonsterstuff.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;
import java.util.stream.Collectors;

public class EnderBlockEntity extends BlockEntity {
    public static final VoxelShape ABOVE_SHAPE = Block.createCuboidShape(6.0, 16.0, 6.0, 10.0, 26, 10.0);
    private int detectionWindow = -1;

    public EnderBlockEntity(BlockPos pos, BlockState state) {
        super(BlocksOfMonsterStuffBlockEntities.ENDER_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        this.detectionWindow = nbt.getInt("DetectionWindow");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.putInt("DetectionWindow", this.detectionWindow);
    }

    public void tp(World world, BlockPos pos, LivingEntity entity, boolean isUp) {
        if ((!isUp || !world.isSkyVisible(pos.up()))) {
            Double tpHeight = findTpHeight(world, pos.up(), entity, isUp);
            if (tpHeight != null) {
                double x = entity.getX();
                double z = entity.getZ();
                if (isUp) {
                    entity.setVelocity(Vec3d.ZERO);
                } else {
                    entity.setSneaking(false);
                }
                entity.requestTeleport(x, tpHeight, z);
                world.playSound(null, x, tpHeight, z, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 10, 1);
            }
        }
    }

    public Double findTpHeight(World world, BlockPos pos, LivingEntity entity, boolean isUp) {
        int direction = isUp ? 1: -1;
        BlockView blockView = world.getChunkAsView(entity.getChunkPos().x, entity.getChunkPos().z);
        for (int y = pos.getY()+(isUp?(int)Math.ceil(entity.getHeight()):-2);y<world.getTopY() && y>world.getBottomY();y+= direction) {
            BlockPos currentPos = new BlockPos(pos.getX(), y, pos.getZ());
            BlockState currentBlockState = world.getBlockState(currentPos);
            VoxelShape currentCollisionShape = currentBlockState.getCollisionShape(blockView, pos);
            if (!(currentBlockState.isAir() || !currentBlockState.getFluidState().isEmpty()) && !currentCollisionShape.isEmpty() && world.getBlockState(currentPos.up()).getCollisionShape(blockView, currentPos.up()).isEmpty()) {
                return (double) currentPos.up().getY()-((1.0-currentCollisionShape.getMax(Direction.Axis.Y)));
            }
        }
        return null;
    }

    public void processDetectedEntity(World world, BlockPos pos, LivingEntity entity) {
        if (entity.getVelocity().y>0.3) {
            tp(world, pos, entity, true);
        } else if (entity.isSneaky()) {
            tp(world, pos, entity, false);
        }
    }

    public List<LivingEntity> getEntitiesAbove(World world) {
        return ABOVE_SHAPE.getBoundingBoxes().stream().flatMap(box -> world.getEntitiesByClass(LivingEntity.class, box.offset(this.pos.getX(), this.pos.getY(), this.pos.getZ()), EntityPredicates.VALID_ENTITY).stream()).collect(Collectors.toList());
    }

    public void tick(World world1, BlockPos pos, EnderBlockEntity enderBlockEntity) {
        if (enderBlockEntity.isInDetectionWindow()) {
            enderBlockEntity.detectionWindow--;
            List<LivingEntity> entitiesAbove = getEntitiesAbove(world1);
            if (!entitiesAbove.isEmpty()) {
                entitiesAbove.forEach((l) -> processDetectedEntity(world1, pos, l));
            }
        }
    }
    
    public void entitySteppedOn() {
        this.openDetectionWindow();
    }

    private void openDetectionWindow() {
        this.detectionWindow = 8;
    }

    private boolean isInDetectionWindow() {
        return this.detectionWindow > 0;
    }
}
