package yar.wargame.kits;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import yar.wargame.hu.Main;

public class KitFileConfiguration {
	
	private static Main plugin = Main.getPlugin(Main.class);
	
	private static FileConfiguration kitConfig;
	private static File kitFile;
	
	public  static void setup() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		setKitFile(new File(plugin.getDataFolder(), "kits.yml"));
		if (!getKitFile().exists()) {
			try {
				getKitFile().createNewFile();
				Bukkit.getServer().getConsoleSender().sendMessage(Color.GREEN+"kits.yml succesfully created!");
			} catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(Color.RED+"Error: kits.yml file could not create.");
				
			}
		}
		setKitConfig(YamlConfiguration.loadConfiguration(kitFile));
	}

	public static FileConfiguration getKitConfig() {
		return kitConfig;
	}

	private static void setKitConfig(FileConfiguration kitConfig) {
		KitFileConfiguration.kitConfig = kitConfig;
	}

	public static File getKitFile() {
		return kitFile;
	}

	private static void setKitFile(File kitFile) {
		KitFileConfiguration.kitFile = kitFile;
	}
	public static void saveConfig() {
		try {
			getKitConfig().save(kitFile);
		} catch(IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(Color.RED+"Error: kits.yml file could not save.");
		}
	}
	public static void reloadConfig() {
		setKitConfig(YamlConfiguration.loadConfiguration(kitFile));
	}

}
