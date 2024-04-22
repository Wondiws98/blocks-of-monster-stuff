package net.wondiws98.blocksofmonsterstuff.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;
import net.wondiws98.blocksofmonsterstuff.registry.BlocksOfMonsterStuffTags;

import java.util.List;

public class GunpowderBlock extends ColoredFallingBlock {

    public GunpowderBlock(Settings settings) {
        super(new ColorCode(7500402), settings);
    }

    public void explode(World world, BlockPos pos) {
        world.removeBlock(pos, false);
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 5f, false, World.ExplosionSourceType.BLOCK);
    }

    public void integrityCheck(BlockState state, World world, BlockPos pos, BlockState oldState) {
        List<BlockState> environmentalStates = List.of(
                oldState,
                world.getBlockState(pos.up()),
                world.getBlockState(pos.down()),
                world.getBlockState(pos.north()),
                world.getBlockState(pos.south()),
                world.getBlockState(pos.east()),
                world.getBlockState(pos.west())
        );
        if (environmentalStates.stream().anyMatch(this::isBlockStateIgniter)) {
            explode(world, pos);
        }
    }

    public boolean isBlockStateIgniter(BlockState state) {
        return (state.isIn(BlocksOfMonsterStuffTags.Blocks.GUNPOWDER_IGNITERS));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.FLINT_AND_STEEL) || itemStack.isOf(Items.FIRE_CHARGE)) {
            explode(world, pos);
            Item item = itemStack.getItem();
            if (!player.isCreative()) {
                if (itemStack.isOf(Items.FLINT_AND_STEEL)) {
                    itemStack.damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
                } else {
                    itemStack.decrement(1);
                }
            }
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            explode(world, pos);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!world.isClient() && isBlockStateIgniter(neighborState)) {
            explode((World) world, pos);
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (world.isClient()) {
            return;
        }
        explode(world, pos);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient()) {
            BlockPos blockPos = hit.getBlockPos();
            Entity entity = projectile.getOwner();
            if (projectile.isOnFire() && projectile.canModifyAt(world, blockPos)) {
                explode(world, blockPos);
            }
        }
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        this.integrityCheck(state, world, pos, oldState);
        super.onBlockAdded(state, world, pos, oldState, notify);
    }

    @Override
    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        super.onLanding(world, pos, fallingBlockState, currentStateInPos, fallingBlockEntity);
        explode(world, pos);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }
}
