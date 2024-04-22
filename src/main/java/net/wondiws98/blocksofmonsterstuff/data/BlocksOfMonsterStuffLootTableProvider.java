package net.wondiws98.blocksofmonsterstuff.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.wondiws98.blocksofmonsterstuff.block.BlocksOfMonsterStuffBlocks;

public class BlocksOfMonsterStuffLootTableProvider extends FabricBlockLootTableProvider {
    public BlocksOfMonsterStuffLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(BlocksOfMonsterStuffBlocks.ROTTEN_FLESH_BLOCK);
        addDrop(BlocksOfMonsterStuffBlocks.GUNPOWDER_BLOCK);
        addDrop(BlocksOfMonsterStuffBlocks.BLAZE_BLOCK);
        addDrop(BlocksOfMonsterStuffBlocks.ENDER_BLOCK);
        addDrop(BlocksOfMonsterStuffBlocks.STRING_ROLL);
        addDrop(BlocksOfMonsterStuffBlocks.BONE_PILE);
        addDrop(BlocksOfMonsterStuffBlocks.GIANT_SPIDER_EYE);
    }
}
