package yar.wargame.tools;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.kits.Kit;
import yar.wargame.kits.Kits;
import yar.wargame.messages.MessageManager;

public class KitInventory {
	public Inventory getInventory() {
		int number = 9;
		if (9 < Kits.getKits().size() && Kits.getKits().size() <= 18) {
			number = 18;
		}
		else if (18 < Kits.getKits().size() && Kits.getKits().size() <= 27) {
			number = 27;
		}
		else if (27 < Kits.getKits().size() && Kits.getKits().size() <= 36) {
			number = 36;
		} 
		else if (36 < Kits.getKits().size() && Kits.getKits().size() <= 45) {
			number = 45;
		}
		Inventory inv = Bukkit.createInventory(null,number ,Server.colorText(MessageManager.getKitsMessage()));
		for(Kit kit : Kits.getKits()) {
			ArrayList<String> lore = new ArrayList<>();
			for (ItemStack item : kit.getTools()) {
				lore.add(Server.colorText(item.getType().toString()+" &e*"+item.getAmount()));
			}
			ItemStack kitItem = new ItemStack(kit.getIcon(), 1);
			ItemMeta meta = kitItem.getItemMeta();	
			meta.setDisplayName(kit.getPrefix());
			meta.setLore(lore);
			kitItem.setItemMeta(meta);
			inv.addItem(kitItem);
		}
		return inv;
		}

}
