package dev.leonidas.allyoucaneat.datagen;

import dev.leonidas.allyoucaneat.init.BlockInit;
import dev.leonidas.allyoucaneat.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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


        offerFoodCookingRecipe(exporter,"smelting", RecipeSerializer.SMELTING,200,ItemInit.BUCKET,ItemInit.CHICKEN_BUCKET,0.7f);


    }
}
