package yar.wargame.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import yar.wargame.hu.Main;
import yar.wargame.tools.KitInventory;

public class cannon implements CommandExecutor {
	
	public void addCommand() {
		Bukkit.getPluginCommand("cannon").setExecutor(this);
	}
	
	Main main = Main.getPlugin(Main.class);
	@Override
	public boolean onCommand(CommandSender send, Command cmd, String str, String[] args) {
		Player pl = (Player)send;
		if (pl.isOp()) {
			
		}		
		return false;
	}
	public void openKits(Player pl) {
		pl.openInventory(new KitInventory().getInventory());
	}
}
