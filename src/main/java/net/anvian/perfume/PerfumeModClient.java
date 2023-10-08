package net.anvian.perfume;

import net.anvian.perfume.block.ModBlocks;
import net.anvian.perfume.screen.ModScreenHandlers;
import net.anvian.perfume.screen.PerfumeMachineScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class PerfumeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PERFUME_MACHINE, RenderLayer.getCutout());
        HandledScreens.register(ModScreenHandlers.PERFUME_MACHINE_SCREEN_HANDLER, PerfumeMachineScreen::new);
    }
}
