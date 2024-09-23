package dev.leonidas.allyoucaneat.datagen;

import dev.leonidas.allyoucaneat.crops.OnionCropBlock;
import dev.leonidas.allyoucaneat.crops.TomatoCropBlock;
import dev.leonidas.allyoucaneat.init.BlockInit;
import dev.leonidas.allyoucaneat.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.TEST_BLOCK);



        // CROPS
        blockStateModelGenerator.registerCrop(BlockInit.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4 ,5);
        blockStateModelGenerator.registerCrop(BlockInit.ONION_CROP, OnionCropBlock.AGE, 0, 1, 2, 3, 4, 5);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ItemInit.BUCKET, Models.GENERATED);
        itemModelGenerator.register(ItemInit.CHICKEN_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ItemInit.BACON_SANDWICH, Models.GENERATED);

        itemModelGenerator.register(ItemInit.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ItemInit.ONION, Models.GENERATED);

    }
}
