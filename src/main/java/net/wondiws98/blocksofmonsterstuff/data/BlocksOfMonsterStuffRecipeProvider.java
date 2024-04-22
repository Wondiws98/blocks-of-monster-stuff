package net.wondiws98.blocksofmonsterstuff.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.wondiws98.blocksofmonsterstuff.block.BlocksOfMonsterStuffBlocks;

public class BlocksOfMonsterStuffRecipeProvider extends FabricRecipeProvider {
    public BlocksOfMonsterStuffRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        RecipeCategory misc = RecipeCategory.MISC;
        RecipeCategory brew = RecipeCategory.BREWING;
        offerReversibleCompactingRecipes(exporter, brew, Items.ROTTEN_FLESH, misc, BlocksOfMonsterStuffBlocks.ROTTEN_FLESH_BLOCK);
        offerReversibleCompactingRecipes(exporter, brew, Items.GUNPOWDER, misc, BlocksOfMonsterStuffBlocks.GUNPOWDER_BLOCK);
        offerReversibleCompactingRecipes(exporter, brew, Items.BLAZE_ROD, misc, BlocksOfMonsterStuffBlocks.BLAZE_BLOCK);
        offer2x2ReversibleCompactingRecipe(exporter, misc, Items.ENDER_PEARL, BlocksOfMonsterStuffBlocks.ENDER_BLOCK, "ender");
        offerReversibleCompactingRecipes(exporter, misc, Items.STRING, misc, BlocksOfMonsterStuffBlocks.STRING_ROLL);
        offerReversibleCompactingRecipes(exporter, misc, Items.BONE, misc, BlocksOfMonsterStuffBlocks.BONE_PILE);
        offerReversibleCompactingRecipes(exporter, brew, Items.SPIDER_EYE, misc, BlocksOfMonsterStuffBlocks.GIANT_SPIDER_EYE);
    }

    public void offer2x2ReversibleCompactingRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible from, ItemConvertible to, String group) {
        offerShapelessRecipe(exporter, from, to, group, 4);
        ShapedRecipeJsonBuilder.create(recipeCategory, to).pattern("FF").pattern("FF").input('F', from).criterion(hasItem(from), conditionsFromItem(from)).offerTo(exporter, new Identifier(getRecipeName(to)));
    }
}
