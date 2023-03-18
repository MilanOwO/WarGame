package yar.wargame.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arena;
import yar.wargame.arenas.Arenas;
import yar.wargame.heal.Heal;
import yar.wargame.heal.Heals;
import yar.wargame.managers.Game;
import yar.wargame.managers.GameState;
import yar.wargame.tools.KitInventory;
import yar.wargame.tools.Scoreboard;
import yar.wargame.tools.Server;
import yar.wargame.weapons.Weapon;

public class GameListener implements Listener {
	
	@EventHandler(priority = EventPriority.LOW)
	public void towerBreakEvent(BlockBreakEvent e) {
		
		try {
			if (Arenas.getPlayerArena(e.getPlayer()) == null)
				return;
		if (Arenas.getPlayerArena(e.getPlayer()).getGameState() == GameState.INGAME) {
			
			if (Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).isDestroyed()) {
				e.setCancelled(true);
				return;
			}
			 	
			else if (Arenas.getPlayerArena(e.getPlayer()).getTeams().getTower(e.getBlock().getLocation()).isDestroyed()){
				e.setCancelled(true);
				return;
			}
			else if (Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).isDestroyed()){
				e.setCancelled(true);
				return;
			}
			else if (Arenas.getPlayerArena(e.getPlayer()).getTeams().getPlayerTeam(e.getPlayer()) == Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation())){
				e.setCancelled(true);
				return;
			}
			else if (Arenas.getPlayerArena(e.getPlayer()).getTeams().getTower(e.getBlock().getLocation()) == null) {
				e.setCancelled(true);
				return;
			}
				

			if  (Bukkit.getWorld(Arenas.getPlayerArena(e.getPlayer()).getTeams().getTower(e.getBlock().getLocation()).getLoc().getWorld().getName()) != null && Arenas.getPlayerArena(e.getPlayer()).getTeams().getTower(e.getBlock().getLocation()).getLoc().getX() == e.getBlock().getX() && Arenas.getPlayerArena(e.getPlayer()).getTeams().getTower(e.getBlock().getLocation()).getLoc().getY() == e.getBlock().getY() && Arenas.getPlayerArena(e.getPlayer()).getTeams().getTower(e.getBlock().getLocation()).getLoc().getZ() == e.getBlock().getLocation().getZ()) {
			Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).destroyTower(Arenas.getPlayerArena(e.getPlayer()).getTeams().getTower(e.getBlock().getLocation()));
			Arenas.getPlayerArena(e.getPlayer()).getPlayers().forEach(p -> Server.sendMessage(p, "&c"+Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).getName()+MessageManager.getTowerDestroyedByPlayerMessage()+e.getPlayer().getName()));
			ArrayList<Player> towerpl = Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).getPlayers();
			towerpl.forEach(p -> Scoreboard.addIngame(p, Arenas.getPlayerArena(e.getPlayer()), Arenas.getPlayerArena(e.getPlayer()).getGameManager().getCount(), Arenas.getPlayerArena(e.getPlayer()).getTeamNumber()-Arenas.getPlayerArena(e.getPlayer()).getTeamsDestroyed().size(),Arenas.getPlayerArena(e.getPlayer()).getTowersNumber()-Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).getTowersDestroyed().size()));
		}	
			if (Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).getTowersDestroyed().size() == Arenas.getPlayerArena(e.getPlayer()).getTowersNumber()) {
			Arenas.getPlayerArena(e.getPlayer()).destroyTeam(Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()));	
			Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).getPlayers().forEach(p -> p.setGameMode(GameMode.SPECTATOR));
			Arenas.getPlayerArena(e.getPlayer()).getPlayers().forEach(p -> Server.sendMessage(p, "&c"+Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).getName()+MessageManager.getTeamDestroyedMessage()));
			Arenas.getPlayerArena(e.getPlayer()).getPlayers().forEach(p -> Scoreboard.addIngame(p, Arenas.getPlayerArena(p), Arenas.getPlayerArena(p).getGameManager().getCount(), Arenas.getPlayerArena(p).getTowersNumber()-Arenas.getPlayerArena(p).getTeams().getPlayerTeam(p).getTowersDestroyed().size(),Arenas.getPlayerArena(p).getTeamNumber()-Arenas.getPlayerArena(p).getTeamsDestroyed().size()));
		}
			if (Arenas.getPlayerArena(e.getPlayer()).getTeamsDestroyed().size() == Arenas.getPlayerArena(e.getPlayer()).getTeamNumber()-1) {
			Arenas.getPlayerArena(e.getPlayer()).getPlayers().forEach(p -> Scoreboard.addIngame(p, Arenas.getPlayerArena(e.getPlayer()), Arenas.getPlayerArena(e.getPlayer()).getGameManager().getCount(), Arenas.getPlayerArena(e.getPlayer()).getTeamNumber()-Arenas.getPlayerArena(e.getPlayer()).getTeamsDestroyed().size(),Arenas.getPlayerArena(e.getPlayer()).getTowersNumber()-Arenas.getPlayerArena(e.getPlayer()).getTeams().getTeamByTower(e.getBlock().getLocation()).getTowersDestroyed().size()));
			Game.end(Arenas.getPlayerArena(e.getPlayer()));
			Arenas.getPlayerArena(e.getPlayer()).setDefault();
			
		}
		
		e.setCancelled(true);
	} 
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	@EventHandler(priority = EventPriority.LOW)
	public void playerQuitEvent(PlayerQuitEvent e) {
		if (Arenas.getPlayerArena(e.getPlayer()) == null)
				return;
		if (Arenas.getPlayerArena(e.getPlayer()).getGameState() == GameState.INGAME || Arenas.getPlayerArena(e.getPlayer()).getGameState() == GameState.LOBBY ) {
			Game.leave(Arenas.getPlayerArena(e.getPlayer()), e.getPlayer());
		}
	}
	@EventHandler
	public void playerDeathEvent(PlayerDeathEvent e) {
		if (Arenas.getPlayerArena(e.getEntity()) == null)
			return;
		try {
		if (Arenas.getPlayerArena(e.getEntity()).getGameState() == GameState.INGAME) {
			e.setDeathMessage(Server.colorText("&c"+e.getEntity().getName()+MessageManager.getPlayerKilledByPlayerMessage()+e.getEntity().getKiller().getName()));
			return;
		}
		} catch(Exception ex) {
			return;
		}
		
	}
	@EventHandler
	public void playerRespawnEvent(PlayerRespawnEvent e) {
		try 
		{
		Player pl = e.getPlayer();
		if (Arenas.getPlayerArena(e.getPlayer()).getGameState() == GameState.INGAME) 
		{
			e.setRespawnLocation(Arenas.getPlayerArena(e.getPlayer()).getTeams().getPlayerTeam(e.getPlayer()).getSpawnLocation());
			pl.openInventory(new KitInventory().getInventory());
			for (Weapon weapon : Arenas.getPlayerArena(e.getPlayer()).getEquipments().getEquipment(pl).getWeapons()) 
			{
				weapon.setCurrentAmmo(weapon.getMaxAmmo());
				weapon.setCurrentLoadedAmmo(weapon.getMaxLoadedAmmo());
				
			}
			EquipmentListener.giveItem(pl);
			for (Heal heal : Heals.getHeals()) 
			{
				ItemStack item = new ItemStack(heal.getHealItem(), 20);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e"+heal.getName()));
				item.setItemMeta(meta);
				pl.getInventory().addItem(item);
			}		
			return;
		}
		} 
		catch(NullPointerException ex) 
		{
			e.setRespawnLocation(Bukkit.getWorld("world").getSpawnLocation());
			return;
		}

	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void playerDamageEvent(EntityDamageByEntityEvent e) {
		
		try {
		Player pl = (Player)e.getEntity();
		Arena arena = Arenas.getPlayerArena(pl);
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		
		if (e.getEntity() instanceof Player) {
			if (arena.getGameState() == GameState.INGAME) {
				for (Player p : arena.getTeams().getPlayerTeam(pl).getPlayers()) {
					if (p == e.getDamager()) {
						e.setCancelled(true);
						Server.sendMessage((Player)e.getDamager(), MessageManager.getCantDamageTeammateMessage());
						break;
					}
				}
			}
		}
		} catch(Exception ex) {
			return;
		}
	}
}
