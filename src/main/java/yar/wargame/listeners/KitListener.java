package yar.wargame.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import yar.wargame.kits.Kits;

public class KitListener implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		try {
		for (int i = 0; i<Kits.getKits().size(); i++) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Kits.getKits().get(i).getPrefix())) {
				Kits.giveKit((Player)e.getWhoClicked(), Kits.getKits().get(i).getName());
				e.getWhoClicked().closeInventory();
				e.setCancelled(true);
			}
		}
		
		
	} catch(NullPointerException ex) {
		return;
	}
		
	}

}
