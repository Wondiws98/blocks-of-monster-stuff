package net.wondiws98.blocksofmonsterstuff.registry;


import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.wondiws98.blocksofmonsterstuff.BlocksOfMonsterStuffMain;
public class BlocksOfMonsterStuffTags {
    public static class Blocks {
        public static final TagKey<Block> GUNPOWDER_IGNITERS = createTag("gunpowder_igniters");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(BlocksOfMonsterStuffMain.MOD_ID, name));
        }
    }
}
