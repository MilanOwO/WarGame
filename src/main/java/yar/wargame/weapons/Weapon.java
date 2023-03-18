package yar.wargame.weapons;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material; 
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import yar.wargame.hu.Main;
import yar.wargame.messages.MessageManager;
import yar.wargame.tools.Server;

import org.bukkit.ChatColor;

public class Weapon {
	
	private int maxAmmo;
	private int currentAmmo;
	private int maxLoadedAmmo;
	private int currentLoadedAmmo;
	private Material useItem;
	private String name;
	private String prefix; 
	private WeaponType type;
	private double ammoDamage;
	private double ammoSpeed;
	private int rechargeSpeed;
	private int reloadSpeed;
	private ArrayList<String> cooldown = new ArrayList<>();
	private boolean reload = false;
	public Weapon(String name, String prefix,int maxAmmo, int maxLoadedAmmo, Material useItem, WeaponType type, double ammoDamage, double ammoSpeed, int rechargeSpeed, int reloadSpeed) {
		setMaxAmmo(maxAmmo);
		setMaxLoadedAmmo(maxLoadedAmmo);
		setName(name);
		setUseItem(useItem);
		setCurrentAmmo(maxAmmo);
		setCurrentLoadedAmmo(maxLoadedAmmo);
		setType(type);
		setAmmoDamage(ammoDamage);
		setAmmoSpeed(ammoSpeed);
		setRechargeSpeed(rechargeSpeed);
		setReloadSpeed(reloadSpeed);
		setPrefix(prefix);
	}

	public int getMaxAmmo() {
		return maxAmmo;
	}

	public void setMaxAmmo(int maxAmmo) {
		this.maxAmmo = maxAmmo;
	}

	public int getCurrentAmmo() {
		return currentAmmo;
	}

	public void setCurrentAmmo(int currentAmmo) {
		this.currentAmmo = currentAmmo;
	}

	public int getMaxLoadedAmmo() {
		return maxLoadedAmmo;
	}

	public void setMaxLoadedAmmo(int maxLoadedAmmo) {
		this.maxLoadedAmmo = maxLoadedAmmo;
	}

	public int getCurrentLoadedAmmo() {
		return currentLoadedAmmo;
	}

	public void setCurrentLoadedAmmo(int currentLoadedAmmo) {
		this.currentLoadedAmmo = currentLoadedAmmo;
	}

	public Material getUseItem() {
		return useItem;
	}

	public void setUseItem(Material useItem) {
		this.useItem = useItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	@SuppressWarnings("deprecation")
	public void reload(Player player) {
		if (isReload())
			return;
		if (currentLoadedAmmo==maxLoadedAmmo)
			return;
		ItemStack item = player.getItemInHand(); 
		ItemMeta meta = player.getItemInHand().getItemMeta();
		
		meta.setDisplayName(Server.colorText(MessageManager.getWeaponReloadMessage()));
		item.setItemMeta(meta);
		player.getInventory().setItemInHand(item);
		setReload(true);
		Runnable reload = new Runnable() {
			@Override
			public void run() { 
				
				int index = 0;
				for (int i = 0; i<player.getInventory().getContents().length; i++) {
					try {
					if (player.getInventory().getContents()[i].getType() == item.getType()) {
						index = i;
						break;
					}
					}catch (Exception ex) {
						continue;
					}
				}
				
				currentAmmo-=maxLoadedAmmo-currentLoadedAmmo;
				currentLoadedAmmo=maxLoadedAmmo;
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getPrefix()+" "+getCurrentLoadedAmmo()+"/"+getCurrentAmmo()));
				item.setItemMeta(meta);
				player.getInventory().setItem(index, item);
				setReload(false);
				
				
			}
			
		};
		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), reload, getReloadSpeed());
		
	}
	
	@SuppressWarnings("deprecation")
	public void shoot(Player player) {
		if (isReload())
			return;
		ItemStack item = player.getItemInHand(); 
		ItemMeta meta = player.getItemInHand().getItemMeta();
		Runnable shoot = new Runnable() {
			@Override
			public void run() {
					getCooldown().remove(getName());
			}			
		};
		
		if (getCooldown().contains(getName()))
			return;
		
		if (currentLoadedAmmo != 0) {
			currentLoadedAmmo-=1;
			
			
			if (getType() == WeaponType.SHOTGUN) {
			for (int i = 0; i<3;i++) {
				
				Snowball s = player.launchProjectile(Snowball.class);
				
				double x = i;
						
				s.setVelocity(player.getLocation().getDirection().normalize().multiply(getAmmoSpeed()+x));
			}
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getPrefix()+" "+getCurrentLoadedAmmo()+"/"+getCurrentAmmo()));
				item.setItemMeta(meta);
				player.getInventory().setItemInHand(item);
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), shoot, getRechargeSpeed());
				getCooldown().add(getName());
			} else {
				Snowball s = player.launchProjectile(Snowball.class);
				s.setVelocity(player.getLocation().getDirection().normalize().multiply(getAmmoSpeed()));
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getPrefix()+" "+getCurrentLoadedAmmo()+"/"+getCurrentAmmo()));
				item.setItemMeta(meta);
				player.getInventory().setItemInHand(item);
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), shoot, getRechargeSpeed());
				getCooldown().add(getName());
			}
		}	
	}

	public WeaponType getType() {
		return type;
	}

	public void setType(WeaponType type) {
		this.type = type;
	}

	public double getAmmoDamage() {
		return ammoDamage;
	}

	public void setAmmoDamage(double ammoDamage) {
		this.ammoDamage = ammoDamage;
	}

	public double getAmmoSpeed() {
		return ammoSpeed;
	}

	public void setAmmoSpeed(double ammoSpeed) {
		this.ammoSpeed = ammoSpeed;
	}

	public int getRechargeSpeed() {
		return rechargeSpeed;
	}

	public void setRechargeSpeed(int rechargeSpeed) {
		this.rechargeSpeed = rechargeSpeed;
	}

	public int getReloadSpeed() {
		return reloadSpeed;
	}

	public void setReloadSpeed(int reloadSpeed) {
		this.reloadSpeed = reloadSpeed;
	}

	public ArrayList<String> getCooldown() {
		return cooldown;
	}

	public void setCooldown(ArrayList<String> cooldown) {
		this.cooldown = cooldown;
	}

	public boolean isReload() {
		return reload;
	}

	public void setReload(boolean reload) {
		this.reload = reload;
	}

}
