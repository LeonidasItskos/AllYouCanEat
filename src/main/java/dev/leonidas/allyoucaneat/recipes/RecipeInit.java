package dev.leonidas.allyoucaneat.recipes;

import dev.leonidas.allyoucaneat.AllYouCanEat;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RecipeInit {

    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(AllYouCanEat.MOD_ID, OvenBlockRecipe.Serializer.ID),
                OvenBlockRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(AllYouCanEat.MOD_ID, OvenBlockRecipe.Type.ID),
                OvenBlockRecipe.Type.INSTANCE);


        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(AllYouCanEat.MOD_ID, ProcessorBlockRecipe.Serializer.ID),
                ProcessorBlockRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(AllYouCanEat.MOD_ID, ProcessorBlockRecipe.Type.ID),
                ProcessorBlockRecipe.Type.INSTANCE);
    }
}
