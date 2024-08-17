
package sbs.ashie.thestoragedimension.client.gui;

import sbs.ashie.thestoragedimension.world.inventory.CoreGUIMenu;
import sbs.ashie.thestoragedimension.network.CoreGUIButtonMessage;
import sbs.ashie.thestoragedimension.StoragedimensionMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CoreGUIScreen extends AbstractContainerScreen<CoreGUIMenu> {
	private final static HashMap<String, Object> guistate = CoreGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox Status;
	Button button_enter_dimension;

	public CoreGUIScreen(CoreGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 125;
		this.imageHeight = 100;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("storagedimension:textures/screens/core_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 27 && mouseY > topPos + 73 && mouseY < topPos + 97)
			guiGraphics.renderTooltip(font, Component.translatable("gui.storagedimension.core_gui.tooltip_fuel"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.storagedimension.core_gui.label_storage_core"), 7, 6, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_enter_dimension = Button.builder(Component.translatable("gui.storagedimension.core_gui.button_enter_dimension"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(StoragedimensionMod.MODID, "coregui_button_0"), new CoreGUIButtonMessage(0, x, y, z));
			}
		}).bounds(this.leftPos + 11, this.topPos + 33, 103, 20).build();
		guistate.put("button:button_enter_dimension", button_enter_dimension);
		this.addRenderableWidget(button_enter_dimension);
		Status = new Checkbox(this.leftPos + 30, this.topPos + 74, 20, 20, Component.translatable("gui.storagedimension.core_gui.Status"), false);
		guistate.put("checkbox:Status", Status);
		this.addRenderableWidget(Status);
	}
}
