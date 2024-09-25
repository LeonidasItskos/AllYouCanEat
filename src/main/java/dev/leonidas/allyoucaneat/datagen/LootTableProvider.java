package dev.leonidas.allyoucaneat.datagen;

import dev.leonidas.allyoucaneat.crops.TomatoCropBlock;
import dev.leonidas.allyoucaneat.blocks.BlockInit;
import dev.leonidas.allyoucaneat.items.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        // Multiple Drops
//        addDrop(BlockInit.TEST_BLOCK, block -> drops(block, ItemInit.TOMATO)
//                .apply(SetCountLootFunction.builder(
//                        UniformLootNumberProvider.create(10f,50f))));



        addDrop(BlockInit.TEST_BLOCK);


        // CROPS

        BlockStatePropertyLootCondition.Builder tomato_builder = BlockStatePropertyLootCondition.builder(BlockInit.TOMATO_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5));
        addDrop(BlockInit.TOMATO_CROP, cropDrops(BlockInit.TOMATO_CROP, ItemInit.TOMATO, ItemInit.TOMATO_SEEDS, tomato_builder));

        BlockStatePropertyLootCondition.Builder onion_builder = BlockStatePropertyLootCondition.builder(BlockInit.ONION_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5));
        addDrop(BlockInit.ONION_CROP, cropDrops(BlockInit.ONION_CROP, ItemInit.ONION, ItemInit.ONION_SEEDS, onion_builder));




    }


    public LootTable.Builder multipleDrops(Block drop, Item item) {
        return dropsWithSilkTouch(drop, this.applyExplosionDecay
                (drop, ItemEntry.builder(item).apply(SetCountLootFunction.
                        builder(UniformLootNumberProvider.create(1.0F, 3.0F)))));
    }
}
