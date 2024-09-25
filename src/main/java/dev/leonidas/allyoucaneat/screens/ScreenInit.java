package dev.leonidas.allyoucaneat.screens;

import dev.leonidas.allyoucaneat.screens.oven_screens.OvenBlockScreenHandler;
import dev.leonidas.allyoucaneat.screens.processor_screens.ProcessorBlockScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenInit {

    public static ScreenHandlerType<OvenBlockScreenHandler> OVEN_BLOCK_SCREEN_HANDLER;
    public static ScreenHandlerType<ProcessorBlockScreenHandler> PROCESSOR_BLOCK_SCREEN_HANDLER;


    public static void reigsterScreenHandlers() {
        OVEN_BLOCK_SCREEN_HANDLER = new ScreenHandlerType<>(OvenBlockScreenHandler::new,null);
        PROCESSOR_BLOCK_SCREEN_HANDLER = new ScreenHandlerType<>(ProcessorBlockScreenHandler::new,null);
    }

}
