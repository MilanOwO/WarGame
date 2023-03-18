package yar.wargame.tools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import yar.wargame.messages.MessageManager;

import org.bukkit.ChatColor;

public class Server {
	
 private static String name = MessageManager.getServerName(); 
 private static String prefix = MessageManager.getServerPrefix();
	public static void broadcastMessage(String msg) {
		Bukkit.broadcastMessage(name+msg);
	}
	public static String getName() {
		return name;
	}
	public static void sendMessage(Player pl, String msg) {
		pl.sendMessage(ChatColor.translateAlternateColorCodes('&', name+msg));
	}
	public static void kickPlayer(Player pl, String msg) {
		pl.kickPlayer(name+msg);
	}
	public static String getPrefix() {
		return prefix;
	}
	public static void setPrefix(String prefix) {
		Server.prefix = prefix;
	}
	public static String colorText(String text){
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	public static String colorSendMessage(String text){
		return ChatColor.translateAlternateColorCodes('&', text);
	}

}
