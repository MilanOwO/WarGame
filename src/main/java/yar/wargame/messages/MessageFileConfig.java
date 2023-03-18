package yar.wargame.messages;


import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import yar.wargame.hu.Main;

public class MessageFileConfig {
	
	private static Main plugin = Main.getPlugin(Main.class);
	
	private static FileConfiguration config;
	private static File file;
	
	public  static void setup() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		setFile(new File(plugin.getDataFolder(), "messageConfig.yml"));
		if (!getFile().exists()) {
			try {
				getFile().createNewFile();
				setConfig(YamlConfiguration.loadConfiguration(file));
				getConfig().set("language", "en");
				getConfig().set("serverName", "&bServer &8->&c ");
				getConfig().set("serverPrefix", "&8-----> &bServer &8<-----");
				saveConfig();
				Bukkit.getServer().getConsoleSender().sendMessage("messageConfig.yml succesfully created!");
			} catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage("Error: messageConfig.yml file could not created!");
				
			}
		} else {
			Bukkit.getServer().getConsoleSender().sendMessage("messageConfig.yml succesfully loaded!");
			setConfig(YamlConfiguration.loadConfiguration(file));
		}
	}

	public static FileConfiguration getConfig() {
		return config;
	}

	private static void setConfig(FileConfiguration config) {
		MessageFileConfig.config = config;
	}

	public static File getFile() {
		return file;
	}

	private static void setFile(File file) {
		MessageFileConfig.file = file;
	}
	public static void saveConfig() {
		try {
			getConfig().save(file);
		} catch(IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(Color.RED+"Error: messageConfig.ymls file could not save.");
		}
	}
	public static void reloadConfig() {
		setConfig(YamlConfiguration.loadConfiguration(file));
	}
	
}

