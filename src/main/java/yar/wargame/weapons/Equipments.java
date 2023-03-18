package yar.wargame.weapons;

import java.util.ArrayList;


import org.bukkit.entity.Player;

import yar.wargame.arenas.Arena;


public class Equipments {
	
	private ArrayList<Equipment> equipments = new ArrayList<>();
	private Arena arena;
	
	public Equipments(Arena arena) {
		setArena(arena);
	}
	
	public ArrayList<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(ArrayList<Equipment> eqiupments) {
		this.equipments = eqiupments;
	}
	
	public void build() {
		for (Player player : arena.getPlayers()) {
			equipments.add(Equipment.createEquipment(player));
		}

	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}
	public void setDefault() {
		setEquipments(new ArrayList<>());
	}
	
	public Equipment getEquipment(Player pl) {
		for (Equipment equipment : getEquipments()) {
			if (equipment.getPlayer().equals(pl)) {
				return equipment;
			}
		}
		return null;
	}
	
}
