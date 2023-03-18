package yar.wargame.weapons;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import yar.wargame.hu.Main;

public class WeaponFileManager {
	
	private static Main plugin = Main.getPlugin(Main.class);
	
	private static FileConfiguration config;
	private static File file;
	
	public  static void setup() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		setFile(new File(plugin.getDataFolder(), "weapons.yml"));
		if (!getFile().exists()) {
			try {
				getFile().createNewFile();
				setConfig(YamlConfiguration.loadConfiguration(file));
				Weapons.create(new Weapon("AK47","&aAK47", 180, 30, Material.DIAMOND_HOE, WeaponType.ASSULT, 5, 2, 4, 40));
				Weapons.create(new Weapon("MK23","&cMK23", 72, 12, Material.DIAMOND_SWORD, WeaponType.PISTOL, 6, 1.5, 16, 50));
				Weapons.create(new Weapon("Winchester 1200","&6Winchester 1200", 36, 6, Material.DIAMOND_AXE, WeaponType.SHOTGUN, 40, 1, 20, 60));
				Weapons.create(new Weapon("Uzi","&9Uzi", 150, 25, Material.DIAMOND_PICKAXE, WeaponType.SMG, 3, 1.7, 1, 25));
				Weapons.create(new Weapon("AWM","&2AWM", 30, 5, Material.DIAMOND_SHOVEL, WeaponType.SNIPER, 40, 4, 50, 80));
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"weapons.yml succesfully created!");
			} catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"Error: weapons.yml file could not created!");
				
			}
		} else {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA+"weapons.yml succesfully loaded!");
			setConfig(YamlConfiguration.loadConfiguration(file));
		}
	}

	public static FileConfiguration getConfig() {
		return config;
	}

	private static void setConfig(FileConfiguration config) {
		WeaponFileManager.config = config;
	}

	public static File getFile() {
		return file;
	}

	private static void setFile(File file) {
		WeaponFileManager.file = file;
	}
	public static void saveConfig() {
		try {
			getConfig().save(file);
		} catch(IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"Error: weapons.yml file could not save.");
		}
	}
	public static void reloadConfig() {
		setConfig(YamlConfiguration.loadConfiguration(file));
	}
	
}
