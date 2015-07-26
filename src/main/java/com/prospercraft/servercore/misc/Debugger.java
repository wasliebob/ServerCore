package com.prospercraft.servercore.misc;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class Debugger {
	public Debugger(String name){
		this.name = name;
	}
	public String name;
	public boolean state;
	
	public void setState(boolean state){
		this.state = state;
	}
	
	public void addDebugMessage(String message){
		if(state)
			System.out.println("[" + name + "] " + EnumChatFormatting.RED + message);
	}
}