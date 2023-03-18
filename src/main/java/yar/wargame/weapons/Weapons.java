package yar.wargame.weapons;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;



public class Weapons {
	
private static ArrayList<Weapon> weapons = new ArrayList<>();

	
	public static void create(Weapon weapon) {
		weapons.add(weapon);
		WeaponFileManager.getConfig().set(weapon.getName()+".prefix",weapon.getPrefix());
		WeaponFileManager.getConfig().set(weapon.getName()+".maxAmmo",weapon.getMaxAmmo());
		WeaponFileManager.getConfig().set(weapon.getName()+".maxLoadedAmmo",weapon.getMaxLoadedAmmo());
		WeaponFileManager.getConfig().set(weapon.getName()+".ammoDamage", weapon.getAmmoDamage());
		WeaponFileManager.getConfig().set(weapon.getName()+".ammoSpeed", weapon.getAmmoSpeed());
		WeaponFileManager.getConfig().set(weapon.getName()+".weaponType", weapon.getType().name());
		WeaponFileManager.getConfig().set(weapon.getName()+".useItem", weapon.getUseItem().name());
		WeaponFileManager.getConfig().set(weapon.getName()+".rechargeSpeed", weapon.getRechargeSpeed());
		WeaponFileManager.getConfig().set(weapon.getName()+".reloadSpeed", weapon.getReloadSpeed());
		WeaponFileManager.saveConfig();
	}
	public static void build() {
		FileConfiguration config = WeaponFileManager.getConfig();
		try {
		for (String str : config.getConfigurationSection("").getKeys(false)) {
			Weapon weapon = new Weapon(str, config.getString(str+".prefix"), config.getInt(str+".maxAmmo"), config.getInt(str+".maxLoadedAmmo"), Material.getMaterial(config.getString(str+".useItem")), WeaponType.getType(config.getString(str+".weaponType")), config.getDouble(str+".ammoDamage"), config.getDouble(str+".ammoSpeed"), config.getInt(str+".rechargeSpeed"), config.getInt(str+".reloadSpeed"));
			weapons.add(weapon);
		}
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public static Weapon getWeapon(String name) {
		for (Weapon weapon : weapons) {
			if (weapon.getName().equals(name)) {
				return weapon;
			}
		}
		return null;
	}
	public static ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	public static void setWeapons(ArrayList<Weapon> weapons) {
		Weapons.weapons = weapons;
	}
	
	
	@SuppressWarnings("deprecation")
	public static Material getWeaponType(Player pl){
		for (Weapon weapon : weapons){
			
			if (pl.getItemInHand().getType() == weapon.getUseItem())
				return weapon.getUseItem();
		}
		return null;
	}

}