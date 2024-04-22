package net.wondiws98.blocksofmonsterstuff.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wondiws98.blocksofmonsterstuff.BlocksOfMonsterStuffMain;
import net.wondiws98.blocksofmonsterstuff.block.BlocksOfMonsterStuffBlocks;

public class BlocksOfMonsterStuffBlockEntities<T extends BlockEntity> {
    public static final BlockEntityType<EnderBlockEntity> ENDER_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BlocksOfMonsterStuffMain.MOD_ID, "ender_block_entity"),
            FabricBlockEntityTypeBuilder.create(EnderBlockEntity::new, BlocksOfMonsterStuffBlocks.ENDER_BLOCK).build()
    );
    public static void registerBlockEntities() {}
}
