package net.wondiws98.blocksofmonsterstuff.block;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.wondiws98.blocksofmonsterstuff.block.entity.BlocksOfMonsterStuffBlockEntities;
import net.wondiws98.blocksofmonsterstuff.block.entity.EnderBlockEntity;
import org.jetbrains.annotations.Nullable;

public class EnderBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final MapCodec<EnderBlock> CODEC = EnderBlock.createCodec(EnderBlock::new);
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public EnderBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EnderBlockEntity(pos, state);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        addParticles(state, world, pos, Direction.UP, random);
        addParticles(state, world, pos, Direction.UP, random);
        addParticles(state, world, pos, Direction.DOWN, random);
        addParticles(state, world, pos, Direction.DOWN, random);
    }

    public void addParticles(BlockState state, World world, BlockPos pos, Direction direction, Random random) {
        BlockPos blockPos = pos.offset(direction);
        if (state.isOpaque() && world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
            return;
        }
        double d = direction.getOffsetX() == 0 ? random.nextDouble() : 0.5 + (double)direction.getOffsetX() * 0.6;
        double e = direction.getOffsetY() == 0 ? random.nextDouble() : 0.5 + (double)direction.getOffsetY() * 0.6;
        double f = direction.getOffsetZ() == 0 ? random.nextDouble() : 0.5 + (double)direction.getOffsetZ() * 0.6;
        world.addParticle(ParticleTypes.REVERSE_PORTAL, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 0.0, direction==Direction.UP?((double)random.nextInt(30)+5)/100:-((double)random.nextInt(30)+5)/100, 0.0);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof EnderBlockEntity enderBlockEntity) {
            enderBlockEntity.entitySteppedOn();
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient() ? null: validateTicker(type, BlocksOfMonsterStuffBlockEntities.ENDER_BLOCK_ENTITY, ((world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, blockEntity)));
    }
}
