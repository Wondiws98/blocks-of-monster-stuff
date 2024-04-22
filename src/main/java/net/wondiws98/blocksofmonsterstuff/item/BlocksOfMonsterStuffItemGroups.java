package net.wondiws98.blocksofmonsterstuff.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wondiws98.blocksofmonsterstuff.BlocksOfMonsterStuffMain;
import net.wondiws98.blocksofmonsterstuff.block.BlocksOfMonsterStuffBlocks;

public class BlocksOfMonsterStuffItemGroups {
    public static final ItemGroup BLOCKS_OF_MONSTER_STUFF = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(BlocksOfMonsterStuffMain.MOD_ID, "blocks_of_monster_stuff"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blocks_of_monster_stuff")).icon(() -> new ItemStack(BlocksOfMonsterStuffBlocks.ROTTEN_FLESH_BLOCK)).entries(((displayContext, entries) -> {
                entries.add(Items.ROTTEN_FLESH);
                entries.add(BlocksOfMonsterStuffBlocks.ROTTEN_FLESH_BLOCK);
                entries.add(Items.GUNPOWDER);
                entries.add(BlocksOfMonsterStuffBlocks.GUNPOWDER_BLOCK);
                entries.add(Items.BLAZE_ROD);
                entries.add(BlocksOfMonsterStuffBlocks.BLAZE_BLOCK);
                entries.add(Items.ENDER_PEARL);
                entries.add(BlocksOfMonsterStuffBlocks.ENDER_BLOCK);
                entries.add(Items.BONE);
                entries.add(BlocksOfMonsterStuffBlocks.BONE_PILE);
                entries.add(Items.SPIDER_EYE);
                entries.add(BlocksOfMonsterStuffBlocks.GIANT_SPIDER_EYE);
                entries.add(Items.STRING);
                entries.add(BlocksOfMonsterStuffBlocks.STRING_ROLL);
            })).build()
    );

    public static void registerItemGroups() {
    }
}
