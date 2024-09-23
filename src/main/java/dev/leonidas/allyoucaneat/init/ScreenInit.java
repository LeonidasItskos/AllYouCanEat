package dev.leonidas.allyoucaneat.init;

import dev.leonidas.allyoucaneat.screens.OvenBlockScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenInit {

    public static ScreenHandlerType<OvenBlockScreenHandler> OVEN_BLOCK_SCREEN_HANDLER;


    public static void reigsterScreenHandlers() {
        OVEN_BLOCK_SCREEN_HANDLER = new ScreenHandlerType<>(OvenBlockScreenHandler::new,null);
    }

}
