package yar.wargame.heal;

import org.bukkit.Material;

public class Heal {

	private String name;
	private int healAmmount;
	private int healCooldown;
	private Material healItem;
	
	public Heal(String name, int healAmmount, int healCooldown, Material healItem) {
		setName(name);
		setHealAmmount(healAmmount);
		setHealCooldown(healCooldown);
		setHealItem(healItem);
	}

	public int getHealAmmount() {
		return healAmmount;
	}

	public void setHealAmmount(int healAmmount) {
		this.healAmmount = healAmmount;
	}

	public int getHealCooldown() {
		return healCooldown;
	}

	public void setHealCooldown(int healCooldown) {
		this.healCooldown = healCooldown;
	}

	public Material getHealItem() {
		return healItem;
	}

	public void setHealItem(Material healItem) {
		this.healItem = healItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
