package yar.wargame.heal;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;


public class Heals {
	
	private static ArrayList<Heal> heals = new ArrayList<>();
	
	
	public static void create(Heal heal) {
		heals.add(heal);
		HealFileManager.getConfig().set(heal.getName()+".healAmmount", heal.getHealAmmount());
		HealFileManager.getConfig().set(heal.getName()+".healCooldown", heal.getHealCooldown());
		HealFileManager.getConfig().set(heal.getName()+".healItem", heal.getHealItem().name());
		HealFileManager.saveConfig();
	}
	public static void build() {
		FileConfiguration config = HealFileManager.getConfig();
		try {
		for (String str : config.getConfigurationSection("").getKeys(false)) {
			Heal heal = new Heal(str, HealFileManager.getConfig().getInt(str+".healAmmount"), HealFileManager.getConfig().getInt(str+".healCooldown"),Material.getMaterial(HealFileManager.getConfig().getString(str+".healItem")));
			heals.add(heal);
		}
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public static ArrayList<Heal> getHeals() {
		return heals;
	}
	public static void setHeal(ArrayList<Heal> heals) {
		Heals.heals= heals;
	}
	public static Heal getHeal(Material material) {
		for (Heal heal : getHeals()) {
			if (heal.getHealItem().name().equals(material.name())) {
				return heal;
			}
		}
		return null;
	}
}
