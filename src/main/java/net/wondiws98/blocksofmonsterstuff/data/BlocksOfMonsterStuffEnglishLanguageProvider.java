package net.wondiws98.blocksofmonsterstuff.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.wondiws98.blocksofmonsterstuff.block.BlocksOfMonsterStuffBlocks;

public class BlocksOfMonsterStuffEnglishLanguageProvider extends FabricLanguageProvider {
    public BlocksOfMonsterStuffEnglishLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(BlocksOfMonsterStuffBlocks.ROTTEN_FLESH_BLOCK, "Block of Rotten Flesh");
        translationBuilder.add(BlocksOfMonsterStuffBlocks.GUNPOWDER_BLOCK, "Block of Gunpowder");
        translationBuilder.add(BlocksOfMonsterStuffBlocks.BLAZE_BLOCK, "Block of Blaze");
        translationBuilder.add(BlocksOfMonsterStuffBlocks.ENDER_BLOCK, "Block of Ender");
        translationBuilder.add(BlocksOfMonsterStuffBlocks.STRING_ROLL, "Roll of String");
        translationBuilder.add(BlocksOfMonsterStuffBlocks.BONE_PILE, "Pile of Bones");
        translationBuilder.add(BlocksOfMonsterStuffBlocks.GIANT_SPIDER_EYE, "Giant Spider Eye");
        translationBuilder.add("itemgroup.blocks_of_monster_stuff", "Blocks of Monster Stuff");
    }
}
