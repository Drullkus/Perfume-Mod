package net.anvian.perfume;

import net.anvian.perfume.screen.ModScreenHandlers;
import net.anvian.perfume.screen.PerfumeMachineScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class PerfumeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.PERFUME_MACHINE_SCREEN_HANDLER, PerfumeMachineScreen::new);
    }
}
