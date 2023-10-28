package net.anvian.perfume.screen;

import net.anvian.perfume.PerfumeMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PerfumeMachineScreenHandler> PERFUME_MACHINE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(PerfumeMod.MOD_ID, "perfume_machine"),
                    new ExtendedScreenHandlerType<>(PerfumeMachineScreenHandler::new));

    public static void registerScreenHandlers() {
        PerfumeMod.LOGGER.info("Registering Screen Handlers for " + PerfumeMod.MOD_ID);
    }
}
