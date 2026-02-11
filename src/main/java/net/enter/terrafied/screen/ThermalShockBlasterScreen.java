package net.enter.terrafied.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.enter.terrafied.Terrafied;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ThermalShockBlasterScreen extends AbstractContainerScreen<ThermalShockBlasterMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Terrafied.MOD_ID, "textures/gui/thermal_shock_blaster_gui.png");

    public ThermalShockBlasterScreen(ThermalShockBlasterMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0 ,TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressionArrow(pGuiGraphics, x, y);
    }

    private void renderProgressionArrow(GuiGraphics pGuiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            pGuiGraphics.blit(TEXTURE, x + 85, y + 30, 176, 0, 0, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
