package dev.leonidas.allyoucaneat.items;

import dev.leonidas.allyoucaneat.AllYouCanEat;
import dev.leonidas.allyoucaneat.blocks.BlockInit;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemInit {

    // ITEMS
    public static final Item BUCKET = registerItem("bucket", new Item(new FabricItemSettings()));



    // FOOD ITEMS
    public static final Item CHICKEN_BUCKET = registerItem("chicken_bucket", new Item(new FabricItemSettings()
            .food(FoodInit.CHICKEN_BUCKET)));

    public static final Item BACON_SANDWICH = registerItem("bacon_sandwich", new Item(new FabricItemSettings()
            .food(FoodInit.BACON_SANDWICH)));




    // CROPS
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings()
            .food(FoodInit.TOMATO)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(BlockInit.TOMATO_CROP, new FabricItemSettings()));

    public static final Item ONION = registerItem("onion", new Item(new FabricItemSettings()
            .food(FoodInit.ONION)));

    public static final Item ONION_SEEDS = registerItem("onion_seeds",
            new AliasedBlockItem(BlockInit.ONION_CROP, new FabricItemSettings()));





    // Method for registering Items without needing to type the entire thing every time
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AllYouCanEat.MOD_ID, name), item);
    }

    // Method for logging to console
    public static void registerItems() {
        AllYouCanEat.LOGGER.info("Registering Items for " + AllYouCanEat.MOD_ID);
    }


}
