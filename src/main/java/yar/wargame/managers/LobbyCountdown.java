package yar.wargame.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import yar.wargame.arenas.Arena;
import yar.wargame.heal.Heal;
import yar.wargame.heal.Heals;
import yar.wargame.hu.Main;
import yar.wargame.listeners.EquipmentListener;
import yar.wargame.messages.MessageManager;
import yar.wargame.teams.Team;
import yar.wargame.teams.Teams;
import yar.wargame.tools.Server;
import yar.wargame.tools.TabPrefix;

public class LobbyCountdown {

	
	private Arena arena;
	private int cd;
	private int count;
	private boolean isStarted;
	public LobbyCountdown(Arena arena) {
		this.arena = arena;
	}
	
	public void start() {	
		if (isStarted == true) {
			return;
		}
		if (arena.getPlayersNumber() >= arena.getMinimumplayer()) {
			try {
			count = arena.getLobbyCountdownTime();
			isStarted = true;
			cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					arena.getPlayers().forEach(p -> p.setLevel(count));
					if (count == 60 || count == 30 || count <= 10 && count != 0) {
						for (Player pl : arena.getPlayers()) {
							Server.sendMessage(pl,MessageManager.getGameStartMessage()+count+MessageManager.getSeconds());
						}
					}
					
					if (count == 0) {
						
						TabPrefix pref = new TabPrefix();
						for (Player pl : arena.getPlayers()) {
							if (!arena.getTeams().playerInTeam(pl)) {
								int min = 0;
								for (int i = 1; i < arena.getTeams().getTeams().size();i++) {
									if (arena.getTeams().getTeams().get(i).getPlayers().size() < arena.getTeams().getTeams().get(min).getPlayers().size()) {
										min = i;
									}
								}
								arena.getTeams().getTeams().get(min).getPlayers().add(pl);
								pref.setTeamPrefix(pl, arena, arena.getTeams().getPlayerTeam(pl), min);
							}
							
							
							
						}
						arena.getPlayers().forEach(p -> p.getInventory().clear());
						arena.setGameState(GameState.INGAME);
						arena.getEquipments().build();
						arena.getGameManager().start();
						for (Player pl : arena.getPlayers()) {
							Server.sendMessage(pl,MessageManager.getGameStartedMessage());
							EquipmentListener.giveItem(pl);
							for (Heal heal : Heals.getHeals()) {
								ItemStack item = new ItemStack(heal.getHealItem(), 20);
								ItemMeta meta = item.getItemMeta();
								meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e"+heal.getName()));
								item.setItemMeta(meta);
								pl.getInventory().addItem(item);
							}
							
						}
						
						
						Bukkit.getScheduler().cancelTask(cd);
					}
					
					count--;
					
				}
			},20,20);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	public void setDefault() {
		isStarted = false;
		count = arena.getLobbyCountdownTime();
		
	}

}
