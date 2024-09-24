package dev.leonidas.allyoucaneat;

import dev.leonidas.allyoucaneat.blocks.BlockEntityInit;
import dev.leonidas.allyoucaneat.blocks.BlockInit;
import dev.leonidas.allyoucaneat.items.ItemInit;
import dev.leonidas.allyoucaneat.utils.*;
import dev.leonidas.allyoucaneat.utils.ModifyLootTables;
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
		ModifyLootTables.registerLootTables();

// MAKE A CUTTER BLOCK THAT IS USED AS A KNIFE


	}
}