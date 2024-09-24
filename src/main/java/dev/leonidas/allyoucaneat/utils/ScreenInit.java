package dev.leonidas.allyoucaneat.utils;

import dev.leonidas.allyoucaneat.screens.oven_screens.OvenBlockScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenInit {

    public static ScreenHandlerType<OvenBlockScreenHandler> OVEN_BLOCK_SCREEN_HANDLER;


    public static void reigsterScreenHandlers() {
        OVEN_BLOCK_SCREEN_HANDLER = new ScreenHandlerType<>(OvenBlockScreenHandler::new,null);
    }

}
