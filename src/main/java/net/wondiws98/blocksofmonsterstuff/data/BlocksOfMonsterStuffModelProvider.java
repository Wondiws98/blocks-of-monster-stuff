package net.wondiws98.blocksofmonsterstuff.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.wondiws98.blocksofmonsterstuff.block.BlocksOfMonsterStuffBlocks;

public class BlocksOfMonsterStuffModelProvider extends FabricModelProvider {

    public BlocksOfMonsterStuffModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlocksOfMonsterStuffBlocks.ROTTEN_FLESH_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksOfMonsterStuffBlocks.GUNPOWDER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksOfMonsterStuffBlocks.BLAZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksOfMonsterStuffBlocks.ENDER_BLOCK);
        registerSideEndSlab(blockStateModelGenerator, (SlabBlock) BlocksOfMonsterStuffBlocks.STRING_ROLL);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksOfMonsterStuffBlocks.BONE_PILE);
        registerHorizontalNoTop(blockStateModelGenerator, BlocksOfMonsterStuffBlocks.GIANT_SPIDER_EYE);
    }

    public void registerHorizontalNoTop(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier frontId = TextureMap.getSubId(block, "_front");
        Identifier genericId = TextureMap.getId(block);
        Identifier identifier = Models.ORIENTABLE.upload(block, TextureMap.of(TextureKey.FRONT, frontId).put(TextureKey.TOP, genericId).put(TextureKey.SIDE, genericId), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    public void registerSideEndSlab(BlockStateModelGenerator blockStateModelGenerator, SlabBlock slabBlock) {
        Identifier sideId = TextureMap.getSubId(slabBlock, "_side");
        Identifier endId = TextureMap.getSubId(slabBlock, "_top");
        TextureMap textureMap2 = TextureMap.sideEnd(sideId, endId);
        Identifier identifier = Models.SLAB.upload(slabBlock, textureMap2, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.SLAB_TOP.upload(slabBlock, textureMap2, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.CUBE_COLUMN.uploadWithoutVariant(slabBlock, "_side", textureMap2, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slabBlock, identifier, identifier2, identifier3));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}

