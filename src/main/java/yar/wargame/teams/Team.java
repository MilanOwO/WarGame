package yar.wargame.teams;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import yar.wargame.arenas.Arena;

public class Team {
	
	private Arena arena;
	private ArrayList<Player> players = new ArrayList<>();
	private Towers towers = new Towers(this, arena);
	private int maximumPlayers;
	private String name;
	private Location spawnLocation;
	private ArrayList<Tower> towersDestroyed = new ArrayList<>();
	private boolean isDestroyed = false;
	private ArrayList<Block> towerBlocks = new ArrayList<>();
	
	
	public Team(int maximumPlayers, String name, Location loc, Arena arena) {
		setArena(arena);
		setSpawnLocation(loc);
		setMaximumPlayers(maximumPlayers);
		this.setName(name);
	}
	
	public int getMaximumPlayers() {
		return maximumPlayers;
	}
	public void setMaximumPlayers(int maximumPlayers) {
		this.maximumPlayers = maximumPlayers;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getSpawnLocation() {
		return spawnLocation;
	}

	public void setSpawnLocation(Location spawnLocation) {
		this.spawnLocation = spawnLocation;
	}

	public Towers getTowers() {
		return towers;
	}

	public void setTowers(Towers towers) {
		this.towers = towers;
	}

	public ArrayList<Tower> getTowersDestroyed() {
		return towersDestroyed;
	}

	public void setTowersDestroyed(ArrayList<Tower> towersDestroyed) {
		this.towersDestroyed = towersDestroyed;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	public ArrayList<Block> getTowerBlocks() {
		return towerBlocks;
	}

	public void setTowerBlocks(ArrayList<Block> towerBlocks) {
		this.towerBlocks = towerBlocks;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}
	
	public void destroyTower(Tower tower) {
		tower.setDestroyed(true);
		Bukkit.getWorld(tower.getLoc().getWorld().getName()).getBlockAt(tower.getLoc()).setType(Material.BEDROCK);
		getTowersDestroyed().add(tower);
	}
	
	public boolean isEmpty() {
		if (players.isEmpty())
			return true;
		return false;
	}
	public boolean isFull() {
		if (getPlayers().size() == getMaximumPlayers())
			return true;
		return false;
	}
	public void setDefault() {
		for(Tower tower : getTowers().getTowers()) {
			Bukkit.getWorld(tower.getLoc().getWorld().getName()).getBlockAt(tower.getLoc()).setType(Material.BLUE_WOOL);
			tower.setDefault();
		}
		towersDestroyed = new ArrayList<>();
		setDestroyed(false);
		setPlayers(new ArrayList<Player>());
		
	}

}
