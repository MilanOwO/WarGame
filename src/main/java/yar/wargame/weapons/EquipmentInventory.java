package yar.wargame.weapons;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arenas;
import yar.wargame.tools.Server;



public class EquipmentInventory {
	public Inventory getInventory(Player pl) {
		int number = 9;
		if (9 < Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons().size() && Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons().size() <= 18) {
			number = 18;
		}
		else if (18 <Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons().size() && Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons().size() <= 27) {
			number = 27;
		}
		else if (27 < Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons().size() && Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons().size() <= 36) {
			number = 36;
		} 
		else if (36 < Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons().size() && Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons().size() <= 45) {
			number = 45;
		}
		Inventory inv = Bukkit.createInventory(null,number ,Server.colorText(MessageManager.getEquipmentMessage()));
		for(Weapon weapon : Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons()) {
			ArrayList<String> lore = new ArrayList<>();
			lore.add(ChatColor.DARK_PURPLE+"Bullet Damage: " +weapon.getAmmoDamage());
			lore.add(ChatColor.DARK_BLUE+"Bullet Speed: " +weapon.getAmmoSpeed());
			ItemStack kitItem = new ItemStack(weapon.getUseItem(), 1);
			ItemMeta meta = kitItem.getItemMeta();	
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', weapon.getPrefix()+" "+weapon.getCurrentLoadedAmmo()+"/"+weapon.getCurrentAmmo()));
			meta.setLore(lore); 
			kitItem.setItemMeta(meta);
			inv.addItem(kitItem);
		}
		return inv;
		}

}
