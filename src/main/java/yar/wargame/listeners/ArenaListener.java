package yar.wargame.listeners;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arena;
import yar.wargame.arenas.ArenaInventory;
import yar.wargame.arenas.Arenas;
import yar.wargame.managers.Game;
import yar.wargame.tools.Server;

public class ArenaListener implements Listener {
	
		
		@EventHandler
		public void onInteract(PlayerInteractEvent e) {
			try {
				
			if (e.getAction() == Action.RIGHT_CLICK_AIR && e.getMaterial() == Material.PAPER && e.getItem().getItemMeta().getDisplayName().equals(Server.colorText(MessageManager.getChoseArenaMessage()))) {
				e.getPlayer().openInventory(new ArenaInventory().getInventory());
			}
			} catch (Exception ex) {
				return;
			}
		}
		@EventHandler
		public void onInventoryClick(InventoryClickEvent e) {
			try {
			for (Arena arena : Arenas.getArenas()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Server.colorText("&a"+arena.getName()))) {
					Game.join(arena, (Player)e.getWhoClicked());
					e.setCancelled(true);
					
				}
			}
			
			
		} catch(NullPointerException ex) {
			return;
		}
			
		}
		
		@EventHandler
		public void onJoin(PlayerJoinEvent e){
			e.getPlayer().getInventory().clear();
			ItemStack arenaItem = new ItemStack(Material.PAPER, 1);
			ItemMeta meta = arenaItem.getItemMeta();	
			
			meta.setDisplayName(Server.colorText(MessageManager.getChoseArenaMessage()));
			arenaItem.setItemMeta(meta);
			e.getPlayer().getInventory().addItem(arenaItem);
		}

	
}
