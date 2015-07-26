package com.prospercraft.servercore.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import com.prospercraft.servercore.interfaces.ICommandExecutor;

public class SSTCommand extends CommandBase{
	public SSTCommand(String commandName, String commandUsage, int permissionLevel, List commandAliases, ICommandExecutor executor){
		this.commandName = commandName;
		this.commandUsage = commandUsage;
		this.permissionLevel = permissionLevel;
		this.commandAliases = commandAliases;
		this.executor = executor;
	}
	public String commandName;
	public String commandUsage;
	public int permissionLevel;
	public List commandAliases;
	public ICommandExecutor executor;
	
	@Override
	public String getCommandName() {
		return this.commandName;
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return this.commandUsage;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		executor.execute(sender, args, getServer(), this);
	}
	
	@Override
	public int getRequiredPermissionLevel(){
		return this.permissionLevel;
	}
	
	@Override
	public List getCommandAliases(){
		return this.commandAliases;
	}
	
	@Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_){
        return false;
    }
	
	
	public MinecraftServer getServer(){
		return MinecraftServer.getServer();
	}
}