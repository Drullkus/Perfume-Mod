package net.anvian.perfume.screen;

import net.anvian.perfume.PerfumeMod;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<PerfumeMachineScreenHandlers> PERFUME_MACHINE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(PerfumeMod.MOD_ID, "perfume_machine"),
                    PerfumeMachineScreenHandlers::new);
}
