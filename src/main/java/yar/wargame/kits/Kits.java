package yar.wargame.kits;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.messages.MessageManager; 
import yar.wargame.tools.Server;


public class Kits {
	
	private static ArrayList<Kit> kits = new ArrayList<>();
	
	public static ArrayList<Kit> getKits() {
		return kits;
	}

	public static void setKits(ArrayList<Kit> kits) {
		Kits.kits = kits;
	}
	
	public static void create(Kit kit) {
		kits.add(kit);
		KitFileConfiguration.getKitConfig().set(kit.getName()+".tools", kit.getTools());
		KitFileConfiguration.getKitConfig().set(kit.getName()+".icon", kit.getIcon().toString());
		KitFileConfiguration.saveConfig();
	}
	public static void build() {
		FileConfiguration config = KitFileConfiguration.getKitConfig();
		try {
		for (String str : config.getConfigurationSection("").getKeys(false)) {
			@SuppressWarnings("unchecked")
			Kit kit = new Kit(str,(ArrayList<ItemStack>) config.getList(str+".tools"), Material.getMaterial(config.getString(str+".icon")));
			kits.add(kit);
		}
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public static void giveKit(Player pl, String name) {
		if (!(getKit(name) == null)) {
			for (ItemStack tool : getKit(name).getTools()) {
				pl.getInventory().addItem(tool);
			}
		} else {
			Server.sendMessage(pl, MessageManager.getKitNotFoundMessage());
		}
			
		
		
	}
	public static void setIcon(Material icon, Kit kit) {
		kit.setIcon(icon);
		KitFileConfiguration.getKitConfig().set(kit.getName()+".icon", icon.toString());
		KitFileConfiguration.saveConfig();
	}
	
	public static void addTool(ItemStack tool,Kit kit) {
		kit.getTools().add(tool);
		KitFileConfiguration.getKitConfig().set(kit.getName()+".tools", kit.getTools());
		KitFileConfiguration.saveConfig();
	}
	public static void removeTool(Material type,Kit kit) {
		for (ItemStack tool : kit.getTools()) {
			if (tool.getType() == type) {
				kit.getTools().remove(tool);
				KitFileConfiguration.getKitConfig().set(kit.getName()+".tools", kit.getTools());
				KitFileConfiguration.saveConfig();
				break;
			}
		}
	}
	public static void addTool(ItemStack tool,Kit kit, String prefix) {
		ItemMeta meta = tool.getItemMeta();
		meta.setDisplayName(prefix);
		tool.setItemMeta(meta);
		kit.getTools().add(tool);
		KitFileConfiguration.getKitConfig().set(kit.getName()+".tools", kit.getTools());
		KitFileConfiguration.saveConfig();
	}
	public static Kit getKit(String name) {
		for (Kit kit : kits) {
			if (kit.getName().equals(name)) {
				return kit;
			}
		}
		return null;
	}
}
