package dev.leonidas.allyoucaneat.loot_tables;

import dev.leonidas.allyoucaneat.items.ItemInit;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModifyAnimalLootTables {
    private static final Identifier COW_ID
            = new Identifier("minecraft", "entities/cow");



    public static void registerLootTables() {

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(COW_ID.equals(id)) {
                LootPool.Builder cow_loot_builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ItemInit.CHICKEN_BUCKET)) // ITEM
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());
                tableBuilder.pool(cow_loot_builder.build());
            }
        });



    }



}
