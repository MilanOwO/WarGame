package yar.wargame.teams;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arena;
import yar.wargame.hu.Main;
import yar.wargame.tools.Server;
import yar.wargame.tools.TabPrefix;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Teams {
	
	private ArrayList<Team> teams = new ArrayList<>();
	private Arena arena;
	private TabPrefix pref = new TabPrefix();
	public Teams(Arena arena) {
		setArena(arena);
	}
	
	public void build() {
		Main main = Main.getPlugin(Main.class);
		for (int i=0; i<arena.getTeamNumber(); i++) {
			int i2= i+1;
			Team team = new Team(arena.getTeamPlayersNumber(),"Team "+i2, (Location) main.getConfig().get("arenas."+arena.getName()+".teams."+i2+".spawn"), arena);
			teams.add(team);
			team.getTowers().build(i, arena);
			
		}
		System.out.println("Teams build");
	}
	
	public void join(int index, Player pl) {
		if (playerInTeam(pl) && (teams.get(index).getPlayers().size() == arena.getTeamPlayersNumber()) == false) {
			getPlayerTeam(pl).getPlayers().remove(pl);
			teams.get(index).getPlayers().add(pl);
			pref.setTeamPrefix(pl, arena, getPlayerTeam(pl), index);
			Server.sendMessage(pl, MessageManager.getTeamJoinMessage());
		}
	else if ((teams.get(index).getPlayers().size() == arena.getTeamPlayersNumber()) == false) {
			teams.get(index).getPlayers().add(pl);
			pref.setTeamPrefix(pl, arena, getPlayerTeam(pl), index);
			Server.sendMessage(pl, MessageManager.getTeamJoinMessage());
		} 
	else {
		Server.sendMessage(pl, MessageManager.getTeamIsFullMessage());
	}
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public Arena getArena() {
		return arena;
	}
	

	public void setArena(Arena arena) {
		this.arena = arena;
	} 
	
	public Tower getTower(Material block) {
		for (Team team : teams) {
			for (Tower tower : team.getTowers().getTowers()) {
				if(tower.getBlock().equals(block)) {
					return tower;
				}
			}
		}
		return null;
	}
	public Team getTeamByTower(Location location) {
		for (Team team : teams) {
			for (Tower tower : team.getTowers().getTowers()) {
				if(Bukkit.getWorld(tower.getLoc().getWorld().getName()) != null && tower.getLoc().getX() == location.getX() &&tower.getLoc().getY() == location.getY() && tower.getLoc().getBlockZ() == location.getBlockZ()) {
					return team;
				}
			}
		}
		return null;
	}
	public Team getPlayerTeam(Player pl) {
		for (Team team : teams) {
			for (Player p : team.getPlayers()) {
				if (pl == p) {
					return team;
				}
			}
		}
		return null;
	}
	public boolean playerInTeam(Player pl) {
		for (Team team : teams) {
			for (Player p : team.getPlayers()) {
				if (pl == p) {
					return true;
				}
			}
		}
			
		return false;
	}
	public Player getPlayer(Player pl) {
		for (Team team : teams) {
			for (Player p : team.getPlayers()) {
				if (pl == p) {
					return pl;
				}
			}
		}
			
		return null;
	}

	public Tower getTower(Location location) {
		for (Team team : teams) {
			for (Tower tower : team.getTowers().getTowers()) {
				if(Bukkit.getWorld(tower.getLoc().getWorld().getName()) != null && tower.getLoc().getX() == location.getX() &&tower.getLoc().getY() == location.getY() && tower.getLoc().getBlockZ() == location.getBlockZ()) {
					return tower;
				}
			}
		}
		return null;
	}


}
