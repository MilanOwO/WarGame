package yar.wargame.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.messages.MessageManager;
import yar.wargame.tools.Server;
import yar.wargame.weapons.EquipmentInventory;

public class EquipmentListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		try {
			
			
		if (e.getAction() == Action.RIGHT_CLICK_AIR && e.getMaterial() == Material.SHULKER_SHELL && e.getItem().getItemMeta().getDisplayName().equals(Server.colorText(MessageManager.getChoseEquipmentMessage()))) {
			e.getPlayer().openInventory(new EquipmentInventory().getInventory(e.getPlayer()));
		}
		} catch (Exception ex) {
			return;
		}
	}
	
	

	public static void giveItem(Player player){
		player.getInventory().clear();
		ItemStack arenaItem = new ItemStack(Material.SHULKER_SHELL, 1);
		ItemMeta meta = arenaItem.getItemMeta();	
		
		meta.setDisplayName(Server.colorText(MessageManager.getChoseEquipmentMessage()));
		arenaItem.setItemMeta(meta);
		player.getInventory().addItem(arenaItem);
	}
}
