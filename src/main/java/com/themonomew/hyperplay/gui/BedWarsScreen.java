package com.themonomew.hyperplay.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class BedWarsScreen extends GuiScreen {
	
	private static final Minecraft MINECRAFT = Minecraft.getMinecraft();
	
	@Override
	public void initGui() {
		buttonList.add(new GuiButton(0, width/2-50, height/2-50, 100, 20, "Solo"));
		buttonList.add(new GuiButton(1, width/2-50, height/2-25, 100, 20, "Doubles"));
		buttonList.add(new GuiButton(2, width/2-50, height/2, 100, 20, "3v3v3v3"));
		buttonList.add(new GuiButton(3, width/2-50, height/2+25, 100, 20, "4v4v4v4"));
		buttonList.add(new GuiButton(4, width/2-50, height/2+50, 100, 20, "Bedwars Hub"));
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id) {
			case 0:
				MINECRAFT.thePlayer.sendChatMessage("/play bedwars_eight_one");
				break;
			case 1:
				MINECRAFT.thePlayer.sendChatMessage("/play bedwars_eight_two");
				break;
			case 2:
				MINECRAFT.thePlayer.sendChatMessage("/play bedwars_four_three");
				break;
			case 3:
				MINECRAFT.thePlayer.sendChatMessage("/play bedwars_four_four");
				break;
			case 4:
				MINECRAFT.thePlayer.sendChatMessage("/hub bedwars");
				break;
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
