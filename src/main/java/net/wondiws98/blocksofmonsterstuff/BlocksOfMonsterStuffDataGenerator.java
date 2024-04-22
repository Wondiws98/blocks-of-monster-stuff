package net.wondiws98.blocksofmonsterstuff;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.wondiws98.blocksofmonsterstuff.data.*;

public class BlocksOfMonsterStuffDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		
		pack.addProvider(BlocksOfMonsterStuffBlockTagProvider::new);
		pack.addProvider(BlocksOfMonsterStuffItemTagProvider::new);
		pack.addProvider(BlocksOfMonsterStuffEnglishLanguageProvider::new);
		pack.addProvider(BlocksOfMonsterStuffLootTableProvider::new);
		pack.addProvider(BlocksOfMonsterStuffModelProvider::new);
		pack.addProvider(BlocksOfMonsterStuffRecipeProvider::new);
	}
}
