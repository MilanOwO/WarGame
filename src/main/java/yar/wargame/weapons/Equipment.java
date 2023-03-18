package yar.wargame.weapons;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Equipment {
	
	private Player player;
	private ArrayList<Weapon> weapons = new ArrayList<>();
	public Equipment(Player player, ArrayList<Weapon> weapons)	{
		setWeapons(weapons);
		setPlayer(player);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(ArrayList<Weapon> weapons) {
		this.weapons = weapons;
	}
	
	public static Equipment createEquipment(Player player) {
		ArrayList<Weapon> weapons = new ArrayList<>();
		for(Weapon weapon : Weapons.getWeapons()) {
			Weapon weapon1 = new Weapon(weapon.getName(),
					weapon.getPrefix(),
					weapon.getMaxAmmo(),
					weapon.getMaxLoadedAmmo(),
					weapon.getUseItem(),
					weapon.getType(),
					weapon.getAmmoDamage(),
					weapon.getAmmoSpeed(),
					weapon.getRechargeSpeed(),
					weapon.getReloadSpeed()
					);
			weapons.add(weapon1);
		}
		Equipment equipment = new Equipment(player,weapons);
		return equipment;
	}
}
