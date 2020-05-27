package com.themonomew.hyperplay;

import com.themonomew.hyperplay.command.BedWarsCommand;
import com.themonomew.hyperplay.command.SkyBlockCommand;
import com.themonomew.hyperplay.command.SkyWarsCommand;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

@Mod(modid = HyperPlayMod.MOD_ID, name = HyperPlayMod.MOD_NAME, version = HyperPlayMod.VERSION)
public class HyperPlayMod {
	
	public static final String MOD_ID = "hyperplay";
	public static final String MOD_NAME = "HyperPlay";
	public static final String VERSION = "1.0";
	
	private static final Minecraft MINECRAFT = Minecraft.getMinecraft();
	public static boolean isOnHypixel;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		ClientCommandHandler.instance.registerCommand(new BedWarsCommand(this));
		ClientCommandHandler.instance.registerCommand(new SkyWarsCommand(this));
		ClientCommandHandler.instance.registerCommand(new SkyBlockCommand(this));
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	
	}
	
	@SubscribeEvent
	public void onConnect(FMLNetworkEvent.ClientConnectedToServerEvent e) {
		final ServerData data = MINECRAFT.getCurrentServerData();
		if (data != null && data.serverIP.contains("hypixel.net")) {
				isOnHypixel = true;
		}
	}

	@SubscribeEvent
	public void onDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent e) {
		isOnHypixel = false;
	}
}
