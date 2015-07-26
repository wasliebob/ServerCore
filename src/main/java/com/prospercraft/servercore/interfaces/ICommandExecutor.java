package com.prospercraft.servercore.interfaces;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import com.prospercraft.servercore.commands.SSTCommand;

/**
 * @author Wesley
 */
public interface ICommandExecutor {
	public void execute(ICommandSender sender, String[] args, MinecraftServer server, SSTCommand commandName);
}