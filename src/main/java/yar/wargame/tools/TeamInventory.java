package yar.wargame.tools;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arena;


public class TeamInventory {
	
	public Inventory getInventory(Arena arena) {
	int number = 9;
	if (9 < arena.getTeamNumber() && arena.getTeamNumber() <= 18) {
		number = 18;
	}
	else if (18 < arena.getTeamNumber() && arena.getTeamNumber() <= 27) {
		number = 27;
	}
	else if (27 < arena.getTeamNumber() && arena.getTeamNumber() <= 36) {
		number = 36;
	} 
	else if (36 < arena.getTeamNumber() && arena.getTeamNumber() <= 45) {
		number = 45;
	}
	Inventory inv = Bukkit.createInventory(null,number ,Server.colorText(MessageManager.getTeamsMessage()));
	for(int i = 0; i<arena.getTeamNumber();i++) {
		ItemStack teamItem = new ItemStack(Material.CYAN_WOOL);
		ItemMeta meta = teamItem.getItemMeta();	
		ArrayList<String> lore = new ArrayList<>(); 
		lore.add(Server.colorText("&c"+arena.getTeams().getTeams().get(i).getPlayers().size()+"/"+arena.getTeamPlayersNumber()));
		meta.setDisplayName(Server.colorText("&a"+arena.getTeams().getTeams().get(i).getName()));
		meta.setLore(lore);
		teamItem.setItemMeta(meta);
		inv.addItem(teamItem);
	}
	return inv;
	}

}
