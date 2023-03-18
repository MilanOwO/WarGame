package yar.wargame.arenas;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import net.md_5.bungee.api.ChatColor;
import yar.wargame.messages.MessageManager;
import yar.wargame.tools.Server;

public class ArenaInventory {
	public Inventory getInventory() {
		int number = 9;
		if (9 < Arenas.getArenas().size() && Arenas.getArenas().size() <= 18) {
			number = 18;
		}
		else if (18 < Arenas.getArenas().size() && Arenas.getArenas().size() <= 27) {
			number = 27;
		}
		else if (27 < Arenas.getArenas().size() && Arenas.getArenas().size() <= 36) {
			number = 36;
		} 
		else if (36 < Arenas.getArenas().size() && Arenas.getArenas().size() <= 45) {
			number = 45;
		}
		Inventory inv = Bukkit.createInventory(null,number ,Server.colorText(MessageManager.getArenasMessage()));
		for(Arena arena : Arenas.getArenas()) {
			ItemStack arenaItem = new ItemStack(Material.PAPER, 1);
			ItemMeta meta = arenaItem.getItemMeta();	
			ArrayList<String> lore = new ArrayList<>(); 
			lore.add(ChatColor.translateAlternateColorCodes('&', "&b"+arena.getPlayers().size()+"/"+arena.getMaximumplayer()));
			meta.setDisplayName(Server.colorText("&a"+arena.getName()));
			meta.setLore(lore);
			arenaItem.setItemMeta(meta);
			inv.addItem(arenaItem);
		}
		return inv;
		}
}
