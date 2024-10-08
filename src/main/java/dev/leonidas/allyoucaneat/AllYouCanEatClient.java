package dev.leonidas.allyoucaneat;

import dev.leonidas.allyoucaneat.blocks.BlockInit;
import dev.leonidas.allyoucaneat.screens.processor_screens.ProcessorBlockScreen;
import dev.leonidas.allyoucaneat.screens.ScreenInit;
import dev.leonidas.allyoucaneat.screens.oven_screens.OvenBlockScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class AllYouCanEatClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.ONION_CROP, RenderLayer.getCutout());


        HandledScreens.register(ScreenInit.OVEN_BLOCK_SCREEN_HANDLER, OvenBlockScreen::new);
        HandledScreens.register(ScreenInit.PROCESSOR_BLOCK_SCREEN_HANDLER, ProcessorBlockScreen::new);

    }
}
