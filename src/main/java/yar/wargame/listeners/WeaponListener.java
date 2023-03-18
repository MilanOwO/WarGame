package yar.wargame.listeners;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arena;
import yar.wargame.arenas.Arenas;
import yar.wargame.managers.GameState;
import yar.wargame.tools.Server;
import yar.wargame.weapons.Weapon;

public class WeaponListener implements Listener {
	
	@EventHandler
	public void onShoot(PlayerInteractEvent e) {
		try {
			if (Arenas.getPlayerArena(e.getPlayer()).getEquipments().getEquipment(e.getPlayer()).getWeapons() == null) {
				return;
			}
			if (Arenas.getPlayerArena(e.getPlayer()).getGameState() != GameState.INGAME)
				return;
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
	
				for (Weapon weapon : Arenas.getPlayerArena(e.getPlayer()).getEquipments().getEquipment(e.getPlayer()).getWeapons())  {
					if (e.getMaterial() == weapon.getUseItem()) {					 
						weapon.reload(e.getPlayer());  
						return;
					}				
				}
			}
			

			if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {			
				for (Weapon weapon : Arenas.getPlayerArena(e.getPlayer()).getEquipments().getEquipment(e.getPlayer()).getWeapons())  {
					if (e.getMaterial() == weapon.getUseItem()) {					 
						weapon.shoot(e.getPlayer());  
						return;
					}
				}
			}	
		} catch(Exception ex) {
			return;
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.LOW)
	public void onBulletDamage(EntityDamageByEntityEvent e) {

		try {
			if (e.getEntity() instanceof Player && !(e.getDamager() instanceof Snowball)) {
				e.setCancelled(true);
				return;
			}
			if (e.getDamager() instanceof Snowball) {
				Snowball s = (Snowball) e.getDamager();
				Player pl = (Player) s.getShooter();
				Arena arena = Arenas.getPlayerArena(pl);
				if (arena.getGameState() == GameState.INGAME) {
					for (Player p : arena.getTeams().getPlayerTeam(pl).getPlayers()) {
						if (p == e.getEntity()) {
							e.setCancelled(true);
							Server.sendMessage(pl, MessageManager.getCantDamageTeammateMessage());
							return;
						}
					}
				}
				if (Arenas.getPlayerArena(pl).getGameState() != GameState.INGAME)
					return;
				
				for (Weapon weapon : Arenas.getPlayerArena(pl).getEquipments().getEquipment(pl).getWeapons())  {
					if (weapon.getUseItem() == pl.getItemInHand().getType()) {
						e.setDamage(weapon.getAmmoDamage());
					}
				}
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
