package dev.leonidas.allyoucaneat.utils;

import dev.leonidas.allyoucaneat.AllYouCanEat;
import dev.leonidas.allyoucaneat.blocks.BlockInit;
import dev.leonidas.allyoucaneat.items.ItemInit;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CreativeTabInit {

    public static final ItemGroup ALL_YOU_CAN_EAT_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AllYouCanEat.MOD_ID, "creative_tab"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.allyoucaneat.creative_tab"))
                    .icon(() -> new ItemStack(ItemInit.BUCKET))
                    .entries(((displayContext, entries) -> {


                        entries.add(BlockInit.TEST_BLOCK);
                        entries.add(BlockInit.OVEN_BLOCK);

                        entries.add(ItemInit.BUCKET);
                        entries.add(ItemInit.CHICKEN_BUCKET);
                        entries.add(ItemInit.BACON_SANDWICH);
                        entries.add(ItemInit.TOMATO);
                        entries.add(ItemInit.TOMATO_SEEDS);
                        entries.add(ItemInit.ONION);
                        entries.add(ItemInit.ONION_SEEDS);






                    }))
                    .build());

    public static void registerCreativeTab() {
        AllYouCanEat.LOGGER.info("Registering Creative Tab for " + AllYouCanEat.MOD_ID);

    }
}
