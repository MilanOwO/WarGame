package yar.wargame.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.arenas.Arenas;
import yar.wargame.heal.Heal;
import yar.wargame.heal.Heals;
import yar.wargame.managers.GameState;

public class HealListener implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		try {
			if (e.getAction() == Action.RIGHT_CLICK_AIR) {
				if (Arenas.getPlayerArena(e.getPlayer()).getEquipments().getEquipment(e.getPlayer()).getWeapons() == null) {
					return;
				}
				if (Arenas.getPlayerArena(e.getPlayer()).getGameState() != GameState.INGAME)
					return;
				for (Heal heal : Heals.getHeals())  {
					if (e.getMaterial() == heal.getHealItem()) {
						e.getPlayer().setHealth(e.getPlayer().getHealth()+heal.getHealAmmount());
						e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel()+heal.getHealAmmount());
						ItemStack item = new ItemStack(heal.getHealItem(), 1);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e"+heal.getName()));
						item.setItemMeta(meta);
						e.getPlayer().getInventory().removeItem(item);
						return;
					}

					
				}
			}
		} catch(Exception ex) {
			return;
		}
	}
}


