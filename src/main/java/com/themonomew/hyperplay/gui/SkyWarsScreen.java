package com.themonomew.hyperplay.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class SkyWarsScreen extends GuiScreen {
	
	private static final Minecraft MINECRAFT = Minecraft.getMinecraft();
	
	@Override
	public void initGui() {
		buttonList.add(new GuiButton(0, width/2-103, height/2-50, 206, 20, "Ranked"));
		buttonList.add(new GuiButton(1, width/2-103, height/2-25, 100, 20, "Solo Normal"));
		buttonList.add(new GuiButton(2, width/2+3, height/2-25, 100, 20, "Solo Insane"));
		buttonList.add(new GuiButton(3, width/2-103, height/2, 100, 20, "Doubles Normal"));
		buttonList.add(new GuiButton(4, width/2+3, height/2, 100, 20, "Doubles Insane"));
		buttonList.add(new GuiButton(5, width/2-103, height/2+25, 206, 20, "Skywars Hub"));
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id) {
			case 0:
				MINECRAFT.thePlayer.sendChatMessage("/play ranked_normal");
				break;
			case 1:
				MINECRAFT.thePlayer.sendChatMessage("/play solo_normal");
				break;
			case 2:
				MINECRAFT.thePlayer.sendChatMessage("/play solo_insane");
				break;
			case 3:
				MINECRAFT.thePlayer.sendChatMessage("/play teams_normal");
				break;
			case 4:
				MINECRAFT.thePlayer.sendChatMessage("/play teams_insane");
				break;
			case 5:
				MINECRAFT.thePlayer.sendChatMessage("/hub skywars");
		}
	}
	
	@Override
	public void updateScreen() {
		super.updateScreen();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
