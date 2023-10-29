package net.anvian.perfume.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.anvian.perfume.PerfumeMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PerfumeMachineScreen extends HandledScreen<PerfumeMachineScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(PerfumeMod.MOD_ID, "textures/gui/perfume_machine_gui.png");

    public PerfumeMachineScreen(PerfumeMachineScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        renderProgressBar(context, x, y);
        renderFuelBar(context, x, y);
    }

    private void renderProgressBar(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 84, y + 22, 176, 14, handler.getScaledProgress(), 36);
        }
    }

    private void renderFuelBar(DrawContext context, int x, int y) {
        if(handler.hasFuel()) {
            context.drawTexture(TEXTURE, x + 18, y + 33 + 14 - handler.getScaledFuelProgress(), 176,
                    14 - handler.getScaledFuelProgress(), 14, handler.getScaledFuelProgress());
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
