package net.anvian.perfume;

import net.anvian.perfume.screen.EssenceExtractorScreen;
import net.anvian.perfume.screen.ModScreenHandlers;
import net.anvian.perfume.screen.PerfumeMachineScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class PerfumeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.PERFUME_MACHINE_SCREEN_HANDLER, PerfumeMachineScreen::new);
        HandledScreens.register(ModScreenHandlers.ESSENCE_EXTRACTOR_SCREEN_HANDLER, EssenceExtractorScreen::new);
    }
}
