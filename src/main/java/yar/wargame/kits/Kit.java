package yar.wargame.kits;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Kit {
	
	private ArrayList<ItemStack> tools;
	private String name;
	private Material icon;
	private String prefix;
	
	public Kit(String name, ArrayList<ItemStack> tools, Material icon) {
		setTools(tools);
		setName(name);
		setIcon(icon);
		setPrefix("§a"+name);
	}

	public ArrayList<ItemStack> getTools() {
		return tools;
	}

	public void setTools(ArrayList<ItemStack> tools) {
		this.tools = tools;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Material getIcon() {
		return icon;
	}

	public void setIcon(Material icon) {
		this.icon = icon;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	

}
