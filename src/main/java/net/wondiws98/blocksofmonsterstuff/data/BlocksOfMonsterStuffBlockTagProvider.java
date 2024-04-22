package net.wondiws98.blocksofmonsterstuff.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.wondiws98.blocksofmonsterstuff.block.BlocksOfMonsterStuffBlocks;
import net.wondiws98.blocksofmonsterstuff.registry.BlocksOfMonsterStuffTags;

import java.util.concurrent.CompletableFuture;

public class BlocksOfMonsterStuffBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlocksOfMonsterStuffBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlocksOfMonsterStuffTags.Blocks.GUNPOWDER_IGNITERS)
                .add(BlocksOfMonsterStuffBlocks.BLAZE_BLOCK)
                .add(Blocks.MAGMA_BLOCK)
                .add(Blocks.LAVA)
                .forceAddTag(BlockTags.FIRE)
                .forceAddTag(BlockTags.CAMPFIRES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(BlocksOfMonsterStuffBlocks.BLAZE_BLOCK)
                .add(BlocksOfMonsterStuffBlocks.ENDER_BLOCK)
                .add(BlocksOfMonsterStuffBlocks.BONE_PILE);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
               .add(BlocksOfMonsterStuffBlocks.GUNPOWDER_BLOCK);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(BlocksOfMonsterStuffBlocks.STRING_ROLL)
                .add(BlocksOfMonsterStuffBlocks.ROTTEN_FLESH_BLOCK)
                .add(BlocksOfMonsterStuffBlocks.GIANT_SPIDER_EYE);

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(BlocksOfMonsterStuffBlocks.STRING_ROLL)
                .add(BlocksOfMonsterStuffBlocks.ROTTEN_FLESH_BLOCK)
                .add(BlocksOfMonsterStuffBlocks.GIANT_SPIDER_EYE);
    }
}
