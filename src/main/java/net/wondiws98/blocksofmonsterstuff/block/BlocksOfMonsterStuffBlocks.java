package net.wondiws98.blocksofmonsterstuff.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.wondiws98.blocksofmonsterstuff.BlocksOfMonsterStuffMain;
import net.wondiws98.blocksofmonsterstuff.sound.BlocksOfMonsterStuffSoundGroups;

public class BlocksOfMonsterStuffBlocks {
    public static final Block ROTTEN_FLESH_BLOCK = registerBlock("rotten_flesh_block", new RottenFleshBlock(FabricBlockSettings.create().solid().collidable(true).sounds(BlocksOfMonsterStuffSoundGroups.ROTTEN_FLESH_GROUP)));
    public static final Block GUNPOWDER_BLOCK = registerBlock("gunpowder_block", new GunpowderBlock(FabricBlockSettings.copyOf(Blocks.SAND).resistance(0f)));
    public static final Block BLAZE_BLOCK = registerBlock("blaze_block", new BlazeBlock(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).luminance(15).sounds(BlocksOfMonsterStuffSoundGroups.BLAZE_GROUP)));
    public static final Block ENDER_BLOCK = registerBlock("ender_block", new EnderBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).sounds(BlockSoundGroup.GLASS)), 16);
    public static final Block STRING_ROLL = registerBlock("string_roll", new SlabBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).burnable()));
    public static final Block BONE_PILE = registerBlock("bone_pile", new Block(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).sounds(BlocksOfMonsterStuffSoundGroups.BONE_GROUP)));
    public static final Block GIANT_SPIDER_EYE = registerBlock("giant_spider_eye", new WearableCarvedPumpkinBlock(FabricBlockSettings.copyOf(BlocksOfMonsterStuffBlocks.ROTTEN_FLESH_BLOCK)) {
    });

    private static Block registerBlock(String name, Block block, int stackSize) {
        registerBlockItem(name, block, stackSize);
        return Registry.register(
                Registries.BLOCK,
                new Identifier(BlocksOfMonsterStuffMain.MOD_ID, name),
                block
        );
    }

    private static Block registerBlock(String name, Block block) {
        return BlocksOfMonsterStuffBlocks.registerBlock(name, block, 64);
    }

    private static Item registerBlockItem(String name, Block block, int stackSize) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(BlocksOfMonsterStuffMain.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().maxCount(stackSize))
        );
    }

    public static void registerSoulStuffBlocks() {
        FlammableBlockRegistry.getDefaultInstance().add(STRING_ROLL, 30, 60);
    }
}
