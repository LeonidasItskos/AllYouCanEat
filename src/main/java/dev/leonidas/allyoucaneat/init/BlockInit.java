package dev.leonidas.allyoucaneat.init;

import dev.leonidas.allyoucaneat.AllYouCanEat;
import dev.leonidas.allyoucaneat.blocks.OnPlaceBlock;
import dev.leonidas.allyoucaneat.blocks.OvenBlock;
import dev.leonidas.allyoucaneat.crops.OnionCropBlock;
import dev.leonidas.allyoucaneat.crops.TomatoCropBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlockInit {

    // ON PLACE
    public static final Block TEST_BLOCK = registerBlock("test_block",
            new OnPlaceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));


    public static final Block OVEN_BLOCK = registerBlock("oven_block",
            new OvenBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));



    // CROPS

    public static final Block TOMATO_CROP = Registry.register(Registries.BLOCK, new Identifier(AllYouCanEat.MOD_ID, "tomato_crop"),
            new TomatoCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block ONION_CROP = Registry.register(Registries.BLOCK, new Identifier(AllYouCanEat.MOD_ID, "onion_crop"),
            new OnionCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));





    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(AllYouCanEat.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(AllYouCanEat.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks() {
        AllYouCanEat.LOGGER.info("Registering Blocks");
    }
}
