package dev.leonidas.allyoucaneat.init;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModifyLootTables {
    private static final Identifier GRASS_BLOCK_ID
            = new Identifier("minecraft", "blocks/grass");
    private static final Identifier IGLOO_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/igloo_chest");



    public static void registerLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(GRASS_BLOCK_ID.equals(id)) {

                LootPool.Builder add_tomato_tograss_builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f))
                        .with(ItemEntry.builder(ItemInit.TOMATO_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());
                tableBuilder.pool(add_tomato_tograss_builder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(GRASS_BLOCK_ID.equals(id)) {
                LootPool.Builder grassPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f))
                        .with(ItemEntry.builder(ItemInit.ONION_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());
                tableBuilder.pool(grassPoolBuilder.build());
            }
        });


    }



}
