package yar.wargame.teams;

import org.bukkit.Location;
import org.bukkit.Material;


public class Tower {
	
	private Location loc;
	private boolean isDestroyed = false;
	private Material block;

	
	public Tower(Location loc, Material block) {
		this.setLoc(loc);
		this.setBlock(block);
	}
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	public boolean isDestroyed() {
		return isDestroyed;
	}
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	public Material getBlock() {
		return block;
	}
	public void setBlock(Material block) {
		this.block = block;
	}
	public void setDefault() {
		setDestroyed(false);
	}
}
