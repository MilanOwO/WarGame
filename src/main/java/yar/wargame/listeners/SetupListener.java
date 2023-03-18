package yar.wargame.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arenas;
import yar.wargame.arenasetup.SetupState;
import yar.wargame.tools.Server;

public class SetupListener implements Listener {
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		try  {
			if (Arenas.getArena(e.getPlayer().getName()).getSetupState()  == SetupState.TOWERSPAWN) {
				Arenas.getArena(e.getPlayer().getName()).getSetup().addTowerSpawn(e.getPlayer(),e.getClickedBlock().getLocation());
				e.setCancelled(true);
				return;
		} 	
		else if (Arenas.getArena(e.getPlayer().getName()).getSetupState()  == SetupState.TEAMSPAWN) {
			Arenas.getArena(e.getPlayer().getName()).getSetup().addTeamSpawn(e.getClickedBlock().getLocation());
			Server.sendMessage(e.getPlayer(), "&aTeam "+Arenas.getArena(e.getPlayer().getName()).getSetup().getTeamsSpawn().size()+MessageManager.getTeamSpawnpositionsetupMessage());
			Server.sendMessage(e.getPlayer(), MessageManager.getNowSetupTowerMessaeg());
			e.setCancelled(true);
			return;
		}
		else if (Arenas.getArena(e.getPlayer().getName()).getSetupState()  == SetupState.LOBBYSPAWN) {
			Arenas.getArena(e.getPlayer().getName()).getSetup().addLobbySpawn(e.getClickedBlock().getLocation());
			Server.sendMessage(e.getPlayer(), MessageManager.getLobbySpawnSetupMessage());
			Server.sendMessage(e.getPlayer(), MessageManager.getNowSetupTeamSpawnMessage());
			e.setCancelled(true);
			return;
		}
		}catch(NullPointerException ex) {
			return;
		}
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e ) {
		try  {
		if (Arenas.getArena(e.getPlayer().getName()).getSetupState() == SetupState.NAME) {
			Arenas.getArena(e.getPlayer().getName()).getSetup().addName(e.getMessage(), e.getPlayer());	
		}
		else if (Arenas.getArena(e.getPlayer().getName()).getSetupState()  == SetupState.LOBBYCOUNTDOWN) {
			Arenas.getArena(e.getPlayer().getName()).getSetup().addLobbyCountdown(Integer.parseInt(e.getMessage()), e.getPlayer());			
		}
		else if (Arenas.getArena(e.getPlayer().getName()).getSetupState()  == SetupState.GAMETIME) {
			Arenas.getArena(e.getPlayer().getName()).getSetup().addGameTime(Integer.parseInt(e.getMessage()), e.getPlayer());
		}
		else if (Arenas.getArena(e.getPlayer().getName()).getSetupState()  == SetupState.TEAMNUMBER) {
			Arenas.getArena(e.getPlayer().getName()).getSetup().addTeamNumber(Integer.parseInt(e.getMessage()), e.getPlayer());
		}
		else if (Arenas.getArena(e.getPlayer().getName()).getSetupState() == SetupState.TEAMPLAYERSNUMBER) {
			Arenas.getArena(e.getPlayer().getName()).getSetup().addTeamPlayersNumber(Integer.parseInt(e.getMessage()), e.getPlayer());
		}
		else if (Arenas.getArena(e.getPlayer().getName()).getSetupState() == SetupState.TOWERNUMBER) {
			Arenas.getArena(e.getPlayer().getName()).getSetup().addTowersNumber(Integer.parseInt(e.getMessage()), e.getPlayer());

		}
		} catch(NullPointerException ex) {
			return;
		} catch(NumberFormatException ex2) {
			Server.sendMessage(e.getPlayer(), MessageManager.getNotNumberErrorMessage());
			return;
		}
	}
}
