package yar.wargame.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import yar.wargame.arenas.Arenas;
import yar.wargame.tools.Server;
import yar.wargame.tools.TabPrefix;
import yar.wargame.tools.TeamInventory;

public class TeamListener implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		try {
		if (e.getAction() == Action.RIGHT_CLICK_AIR && e.getMaterial() == Material.DIAMOND) {
			e.getPlayer().openInventory(new TeamInventory().getInventory(Arenas.getPlayerArena(e.getPlayer())));
		}
		} catch (Exception ex) {
			return;
		}
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		try {
		for (int i = 0; i< Arenas.getPlayerArena((Player) e.getWhoClicked()).getTeams().getTeams().size(); i++) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Server.colorText("&a"+Arenas.getPlayerArena((Player) e.getWhoClicked()).getTeams().getTeams().get(i).getName()))) {
				Arenas.getPlayerArena((Player)e.getWhoClicked()).getTeams().join(i,(Player)e.getWhoClicked());
				e.setCancelled(true);
				e.getWhoClicked().openInventory(new TeamInventory().getInventory(Arenas.getPlayerArena((Player)e.getWhoClicked())));
			}
		}
		
		
	} catch(NullPointerException ex) {
		return;
	}
		
	}
	@EventHandler
	public void onJoinServer(PlayerJoinEvent e) {
		TabPrefix pref = new TabPrefix();
		pref.setDefaultPrefix(e.getPlayer());
	}
}
