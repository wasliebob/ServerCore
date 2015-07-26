package com.prospercraft.servercore.registries;

import java.util.HashMap;

import com.prospercraft.servercore.commands.SSTCommand;

public class CommandRegistry {
	public static HashMap<String, SSTCommand> commands = new HashMap<String, SSTCommand>();
	
	/**
	 * Create a new command and add it to the map <br/>
	 * All commands will need to be registered during the FMLInitializationEvent
	 * 
	 * @param command
	 * The Command that you want to add.
	 */
	public static void addCommand(SSTCommand command){
		commands.put(command.commandName, command);
	}
	
	/**
	 * Get a instance of SSTCommand which is registered with the given commandName.
	 * 
	 * @param commandName
	 * The name of the command.
	 * 
	 * @return The value in the map (a instance of SSTCommand)
	 * 
	 */
	public static SSTCommand getCommand(String commandName){
		return commands.get(commandName);
	}
}