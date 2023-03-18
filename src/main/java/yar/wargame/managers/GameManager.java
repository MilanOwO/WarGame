package yar.wargame.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arena;
import yar.wargame.hu.Main;
import yar.wargame.tools.KitInventory;
import yar.wargame.tools.Scoreboard;
import yar.wargame.tools.Server;

public class GameManager {
	
	private Arena arena;
	private int cd;
	private int count;
	private boolean isStarted;

	
	public GameManager(Arena arena) {
		this.arena = arena;
	}


	public void start() {
		if (arena.getGameState()!= GameState.INGAME)
			return;
		
		if (arena.getPlayersNumber() < arena.getMinimumplayer()) {			
			Game.end(arena);
			arena.setDefault();
			arena.getPlayers().forEach(p -> Server.sendMessage(p,MessageManager.getLackOfPlayerMessage()));
			return;
		}
		//Ha a j�t�k elkezd�d�tt
		else if (isStarted == true) {
			return;
		} 
		//Ha m�g nem kezd�d�tt el a j�t�k, de elegend� j�t�kos van bent.
		else if (arena.getPlayersNumber() >= arena.getMinimumplayer()) {
			try {
				
				
			count = arena.getGameTime();
			isStarted = true;
			//arena.getPlayers().forEach(pl ->Scoreboard.addIngame(pl, arena, count, arena.getTeams().getPlayerTeam(pl).getTowersDestroyed().size(),arena.getTeamNumber()-arena.getTeamsDestroyed().size()));
			arena.getPlayers().forEach(p -> p.teleport(arena.getTeams().getPlayerTeam(p).getSpawnLocation()));
			arena.getPlayers().forEach(pl ->pl.openInventory(new KitInventory().getInventory()));
			//A j�t�kot szab�lyoz� rendszer
			cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					if (count == 60 || count == 30 || count <= 10 && count !=0) {
						for (Player pl : arena.getPlayers()) {
							Server.sendMessage(pl,MessageManager.getGameEndMessage()+count+MessageManager.getSeconds());
						}
					}
					if (arena.getPlayersNumber() <= 1) {
						for (Player pl : arena.getPlayers()) {
							Server.sendMessage(pl,MessageManager.getGameEndedMessage());
						
						}
						Game.end(arena);
						arena.setDefault();
						
					}
					//Ha lej�r a j�t�k id�
					if (count == 0) {
						for (Player pl : arena.getPlayers()) {
							Server.sendMessage(pl,MessageManager.getGameEndedMessage());
						
						}
						Game.end(arena);
						arena.setDefault();
					}
					count--;
					
					arena.getPlayers().forEach(pl ->Scoreboard.addIngame(pl, arena, count,arena.getTeamNumber()-arena.getTeamsDestroyed().size(), arena.getTowersNumber()-arena.getTeams().getPlayerTeam(pl).getTowersDestroyed().size()));
					
				}
			},20,20);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}
	}
	public void setDefault() {
		isStarted = false;
		count = arena.getGameTime();
		arena.setGameState(GameState.LOBBY);
		Bukkit.getScheduler().cancelTask(cd);
	}
	
	public int getCount(){
		return count;
	}
	
}

