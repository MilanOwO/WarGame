package yar.wargame.teams;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;

import yar.wargame.arenas.Arena;
import yar.wargame.hu.Main;


public class Towers {
	
	private Team team;
	private ArrayList<Tower> towers = new ArrayList<>();
	private Arena arena;
	public Towers(Team team, Arena arena) {
		setTeam(team);
		setArena(arena);
	}
	
	public void build(int teamIndex, Arena arena) {
		System.out.println(""+arena.getName());
		int i2 = teamIndex+1;
		Main main = Main.getPlugin(Main.class);
		for (int i=0; i<arena.getTowersNumber(); i++) {
			int i3= i+1;
			Location loc = (Location) main.getConfig().get("arenas."+arena.getName()+".teams."+i2+".tower."+i3+".location");
			Tower tower = new Tower(loc,  Material.getMaterial(main.getConfig().getString("arenas."+arena.getName()+".teams."+i2+".tower."+i3+".type")));
			towers.add(tower);
			System.out.println(tower.getBlock());
		}
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public ArrayList<Tower> getTowers() {
		return towers;
	}

	public void setTowers(ArrayList<Tower> towers) {
		this.towers = towers;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}
}
