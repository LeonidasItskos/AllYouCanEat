package dev.leonidas.allyoucaneat;

import dev.leonidas.allyoucaneat.datagen.BlockTagProvider;
import dev.leonidas.allyoucaneat.datagen.LootTableProvider;
import dev.leonidas.allyoucaneat.datagen.ModelProvider;
import dev.leonidas.allyoucaneat.datagen.RecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AllYouCanEatDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(RecipeProvider::new);

	}
}
