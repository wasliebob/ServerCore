package com.prospercraft.servercore.commands.executors;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import com.prospercraft.servercore.ServerCore;
import com.prospercraft.servercore.commands.SSTCommand;
import com.prospercraft.servercore.interfaces.ICommandExecutor;

public class ExecutorDebug implements ICommandExecutor{
	@Override
	public void execute(ICommandSender sender, String[] args,
			MinecraftServer server, SSTCommand command) {
		if(args.length == 1){
			boolean state = Boolean.parseBoolean(args[0]);
			
			ServerCore.debugger.setState(state);
			sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Changed the debugger state to " + state));
		}else{
			sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Invalid Arguments, " + command.commandUsage));
		}
	}
}