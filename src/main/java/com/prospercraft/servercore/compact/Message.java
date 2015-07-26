package com.prospercraft.servercore.compact;

/**
 * @author Wesley
 */
public class Message {
	public Message(String text){
		this.text = text;
	}
	public String text;
	
	public String divideText(int maxSize){
		StringBuilder sb = new StringBuilder(text);
		
		int i = 0;
		while((i = sb.indexOf(" ", i + maxSize)) >= 0)
			sb.setCharAt(i, '\n');
		
		return sb.toString();
	}
}