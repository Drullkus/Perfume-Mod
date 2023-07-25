package net.anvian.perfume;

import net.anvian.perfume.screen.PerfumeMachineScreen;
import net.anvian.perfume.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class PerfumeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.PERFUME_MACHINE_SCREEN_HANDLER, PerfumeMachineScreen::new);
    }
}
