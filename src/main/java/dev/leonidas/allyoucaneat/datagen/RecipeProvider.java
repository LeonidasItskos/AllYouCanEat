package dev.leonidas.allyoucaneat.datagen;

import dev.leonidas.allyoucaneat.blocks.BlockInit;
import dev.leonidas.allyoucaneat.items.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.BUCKET, 3)
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .input('P',Items.PAPER)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(ItemInit.BUCKET)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.CHICKEN_BUCKET, 1)
                .pattern("S")
                .pattern("B")
                .input('S', Items.COOKED_BEEF)
                .input('B', Items.BREAD)
                .criterion(hasItem(Items.BREAD  ), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, new Identifier(getRecipeName(ItemInit.BACON_SANDWICH)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.OVEN_BLOCK, 1)
                .pattern("SSS")
                .pattern("BFB")
                .pattern("BBB")
                .input('S', Items.STONE_SLAB)
                .input('B', Items.BRICKS)
                .input('F', Items.FURNACE)
                .criterion(hasItem(Items.FURNACE), conditionsFromItem(Items.FURNACE))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.OVEN_BLOCK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.PROCESSOR_BLOCK,1)
                .input(Items.BRICKS, 1)
                .input(Items.STONE,2)
                        .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.PROCESSOR_BLOCK)));
        //offerShapelessRecipe(exporter,BlockInit.PROCESSOR_BLOCK,Items.BRICKS,"test",1);

        offerFoodCookingRecipe(exporter,"smelting", RecipeSerializer.SMELTING,200,ItemInit.BUCKET,ItemInit.CHICKEN_BUCKET,0.7f);


    }
}
