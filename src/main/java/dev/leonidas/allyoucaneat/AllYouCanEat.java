package dev.leonidas.allyoucaneat;

import dev.leonidas.allyoucaneat.blocks.BlockEntityInit;
import dev.leonidas.allyoucaneat.blocks.BlockInit;
import dev.leonidas.allyoucaneat.items.ItemInit;
import dev.leonidas.allyoucaneat.loot_tables.ModifyAnimalLootTables;
import dev.leonidas.allyoucaneat.recipes.RecipeInit;
import dev.leonidas.allyoucaneat.screens.ScreenInit;
import dev.leonidas.allyoucaneat.utils.*;
import dev.leonidas.allyoucaneat.loot_tables.ModifyCropLootTables;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllYouCanEat implements ModInitializer {
	public static final String MOD_ID = "allyoucaneat";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		CreativeTabInit.registerCreativeTab();
		ItemInit.registerItems();
		BlockInit.registerBlocks();
		BlockEntityInit.registerBlockEntities();
		ScreenInit.reigsterScreenHandlers();
		RecipeInit.registerRecipes();
		ModifyCropLootTables.registerLootTables();
		ModifyAnimalLootTables.registerLootTables();

// MAKE A CUTTER BLOCK THAT IS USED AS A KNIFE


	}
}