package com.themonomew.hyperplay.command;

import com.themonomew.hyperplay.HyperPlayMod;
import com.themonomew.hyperplay.gui.BedWarsScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class BedWarsCommand extends CommandBase {
	
	private HyperPlayMod mod;
	
	public BedWarsCommand(HyperPlayMod mod) {
		this.mod = mod;
	}

	@Override
	public String getCommandName() {
		return "bw";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/bw";
	}
	
	@Override public boolean canCommandSenderUseCommand(ICommandSender sender)
	{
		return true;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event)
	{
		MinecraftForge.EVENT_BUS.unregister(this);
		//Check if is on hypixel
		Minecraft.getMinecraft().displayGuiScreen(new BedWarsScreen());
	}

}
