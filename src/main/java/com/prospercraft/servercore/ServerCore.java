package com.prospercraft.servercore;

import com.prospercraft.servercore.commands.SSTCommand;
import com.prospercraft.servercore.commands.executors.ExecutorDebug;
import com.prospercraft.servercore.misc.Debugger;
import com.prospercraft.servercore.registries.CommandRegistry;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = ServerCore.MODID, version = ServerCore.VERSION)
public class ServerCore{
    public static final String MODID = "ServerCore";
    public static final String VERSION = "1.0";
    public static Debugger debugger = new Debugger("ServerCore");
    
    @EventHandler
	public void preInit(FMLPreInitializationEvent event) {
    	if(event.getSide() == Side.SERVER){
    		debugger.setState(true);
    	}
	}

    @EventHandler
	public void init(FMLInitializationEvent event) {
    	if(event.getSide() == Side.SERVER){
    		CommandRegistry.addCommand(new SSTCommand("debug", "/debug <state>", 0, null, new ExecutorDebug()));
    	}
	}

    @EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
    	if(event.getSide() == Side.SERVER){
    		
    	}
	}
    
    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event){
    	for(SSTCommand command : CommandRegistry.commands.values()){
			event.registerServerCommand(command);
			debugger.addDebugMessage("Registered command " + command.commandName);
    	}
    }
}