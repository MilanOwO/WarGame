package yar.wargame.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import yar.wargame.arenas.Arenas;
import yar.wargame.managers.GameState;

@SuppressWarnings({ "deprecation" })
public class BlockerListener implements Listener{
	
	@EventHandler
	public void dropEvent(PlayerDropItemEvent e){
		
		if (!(e.getPlayer().isOp()))
		e.setCancelled(true);
	}
	@EventHandler
	public void blockPlace(BlockPlaceEvent e){
		if (!(e.getPlayer().isOp()))
			e.setCancelled(true);
	}
	@EventHandler
	public void blockBreak(BlockBreakEvent e){
		if (!(e.getPlayer().isOp()))
			e.setCancelled(true);
	}
	@EventHandler
	public void pickUp(PlayerPickupItemEvent e){
		if (!(e.getPlayer().isOp()))
			e.setCancelled(true);
	}
	@EventHandler
	public void damage(EntityDamageEvent e) {
		try {
			if(!(Arenas.playerInArena((Player)e.getEntity()))) {
				e.setCancelled(true);
				return;
			}
			else
			if (!(Arenas.getPlayerArena((Player)e.getEntity()).getGameState() == GameState.INGAME)){	
				e.setCancelled(true);
			}
		} catch (Exception ex){
			return;
		}
		
		
	}
}
