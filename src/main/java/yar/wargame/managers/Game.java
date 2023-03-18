package yar.wargame.managers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arena;
import yar.wargame.arenas.Arenas;
import yar.wargame.tools.Scoreboard;
import yar.wargame.tools.Server;
import yar.wargame.tools.TabPrefix;



public class Game {
	
	private static TabPrefix pref = new TabPrefix();
	//Csatlakoz�s a menethez
	public static void join(Arena arena,Player pl) {
		try {
		//Ha az ar�na elindult vagy nem fut
		if (arena.getGameState() == GameState.INGAME || arena.getGameState() == GameState.STOP) {		
			Server.sendMessage(pl, MessageManager.getArenaIsStartedMessage());
			return;
		}
		//Keres�s a j�t�kosok k�z�tt
		for (Player player : arena.getPlayers()) {
			//Ha csatlakozott m�r a j�t�kos
			if (pl == player) {
				Server.sendMessage(pl, MessageManager.getIsJoinedThisArenaMessage());
				return;
			}
		}
		//Ha m�r csatlakozott valahova 
		for (Arena currentarena : Arenas.getArenas()) {
			for(Player player : currentarena.getPlayers()) {
				if (pl == player) {
					Server.sendMessage(pl,MessageManager.getIsJoinedAnArenaMessage());
					return;
				}
			}
		}
		//Ha tele van m�r az ar�na
		if (arena.getPlayersNumber() == arena.getMaximumplayer()) {
			Server.sendMessage(pl,MessageManager.getArenaIsFullMessage());
			return;
		}
		pl.getInventory().clear();
		//Ha semmi sem igaz, akkor ez t�rt�nik
		ItemStack item = new ItemStack(Material.DIAMOND);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(MessageManager.getChoseTeamMessage());
		item.setItemMeta(meta);
		pl.getInventory().addItem(item);
		arena.getPlayers().add(pl);
		pl.teleport(arena.getSpawnposition());
		arena.getPlayers().forEach(p -> Scoreboard.addIngame(p, arena));
		arena.getLobbyCountdown().start();
		pl.setGameMode(GameMode.SURVIVAL);
		//Keres�s a j�t�kosok k�z�tt
		for (Player player : arena.getPlayers()) {
		int s = arena.getMinimumplayer()-arena.getPlayersNumber();
		//Ha s == 0, akkor ezt �rja ki
		if (s <= 0) {
			Server.sendMessage(player,"&6"+pl.getName()+" "+MessageManager.getJoinGameMessage()+" &c[&4"+arena.getPlayersNumber()+"&c/&4"+arena.getMaximumplayer()+"&c]");
			return;
		}
		//Ha s > 0, akkor ez t�rt�nik
		else if(s > 0)
			Server.sendMessage(player,"&6"+pl.getName()+" "+MessageManager.getJoinGameMessage()+" &c[&4"+arena.getPlayersNumber()+"&c/&4"+arena.getMaximumplayer()+"&c] "+MessageManager.getJoinGameMessage2()+" ["+s+"]");	
		}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	//Kil�p�s az ar�n�b�l
	public static void leave(Arena arena,Player pl) {
		try {
		if(arena.getTeams().getPlayerTeam(pl) != null) {
			pl.getInventory().clear();
			arena.getTeams().getPlayerTeam(pl).getPlayers().remove(pl);
			arena.getPlayers().remove(pl);
		for (Player player : arena.getPlayers()) {
			Server.sendMessage(player,"&6"+pl.getName()+MessageManager.getPlayerLeftMessage()+ "&c[&4"+arena.getPlayersNumber()+"&c/&4"+arena.getMaximumplayer()+"&c]");	
		}
		} else {
			arena.getPlayers().remove(pl);
			for (Player player : arena.getPlayers()) {
				Server.sendMessage(player,"&6"+pl.getName()+MessageManager.getPlayerLeftMessage() +"&c[&4"+arena.getPlayersNumber()+"�c/�4"+arena.getMaximumplayer()+"�c]");	
			} 
			pl.getInventory().clear();
			ItemStack arenaItem = new ItemStack(Material.PAPER, 1);
			ItemMeta meta = arenaItem.getItemMeta();	
			
			meta.setDisplayName(Server.colorText(MessageManager.getChoseArenaMessage()));
			arenaItem.setItemMeta(meta);
			pl.getInventory().addItem(arenaItem);
			}
		pref.setDefaultPrefix(pl);
		Scoreboard.removeScoreBoard(pl);
		pl.teleport(Bukkit.getWorld("world").getSpawnLocation());
		pl.setGameMode(GameMode.SURVIVAL);
		Server.sendMessage(pl,MessageManager.getLeftGameMessage());	
		} catch(Exception ex) {
			ex.printStackTrace();
		
		
		}
	}
	public static void end(Arena arena) {
		for (Player pl : arena.getPlayers()){
			pl.setGameMode(GameMode.SURVIVAL);
			pl.teleport(Bukkit.getWorld("world").getSpawnLocation());
			pl.setHealth(20);
			pl.setFoodLevel(20);
			pl.getInventory().clear();
			pref.setDefaultPrefix(pl);
			ItemStack arenaItem = new ItemStack(Material.PAPER, 1);
			ItemMeta meta = arenaItem.getItemMeta();	
			
			meta.setDisplayName(Server.colorText(MessageManager.getChoseArenaMessage()));
			arenaItem.setItemMeta(meta);
			pl.getInventory().addItem(arenaItem);
			
		}
	}
}
