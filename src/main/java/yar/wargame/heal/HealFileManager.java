package yar.wargame.heal;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import yar.wargame.hu.Main;

public class HealFileManager {
	
	private static Main plugin = Main.getPlugin(Main.class);
	
	private static FileConfiguration config;
	private static File file;
	
	public  static void setup() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		setFile(new File(plugin.getDataFolder(), "heals.yml"));
		if (!getFile().exists()) {
			try {
				getFile().createNewFile();
				setConfig(YamlConfiguration.loadConfiguration(file));
				Heals.create(new Heal("Bandage", 5, 20, Material.PAPER));
				Bukkit.getServer().getConsoleSender().sendMessage(Color.GREEN+"heals.yml succesfully created!");
			} catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(Color.RED+"Error: heals.yml file could not created!");
				
			}
		} else {
			Bukkit.getServer().getConsoleSender().sendMessage("§2heals.yml succesfully loaded!");
			setConfig(YamlConfiguration.loadConfiguration(file));
		}
	}

	public static FileConfiguration getConfig() {
		return config;
	}

	private static void setConfig(FileConfiguration config) {
		HealFileManager.config = config;
	}

	public static File getFile() {
		return file;
	}

	private static void setFile(File file) {
		HealFileManager.file = file;
	}
	public static void saveConfig() {
		try {
			getConfig().save(file);
		} catch(IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(Color.RED+"Error: heals.yml file could not save.");
		}
	}
	public static void reloadConfig() {
		setConfig(YamlConfiguration.loadConfiguration(file));
	}
	
}
