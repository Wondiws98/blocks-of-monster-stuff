package net.wondiws98.blocksofmonsterstuff;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.wondiws98.blocksofmonsterstuff.block.BlocksOfMonsterStuffBlocks;
import net.wondiws98.blocksofmonsterstuff.block.entity.BlocksOfMonsterStuffBlockEntities;
import net.wondiws98.blocksofmonsterstuff.item.BlocksOfMonsterStuffItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlocksOfMonsterStuffMain implements ModInitializer {
	public static final String MOD_ID = "blocks_of_monster_stuff";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BlocksOfMonsterStuffBlockEntities.registerBlockEntities();
		BlocksOfMonsterStuffBlocks.registerSoulStuffBlocks();
		BlocksOfMonsterStuffItemGroups.registerItemGroups();
		FuelRegistry.INSTANCE.add(BlocksOfMonsterStuffBlocks.BLAZE_BLOCK, 24000);
		LOGGER.info("Blocks Of Monster Stuff in!");
	}
}