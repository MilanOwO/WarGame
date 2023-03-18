package yar.wargame.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import yar.wargame.arenas.Arenas;
import yar.wargame.hu.Main;
import yar.wargame.managers.GameState;
import yar.wargame.tools.KitInventory;

public class kits implements CommandExecutor {
	
	public void addCommand() {
		Bukkit.getPluginCommand("kits").setExecutor(this);
	}
	
	Main main = Main.getPlugin(Main.class);
	@Override
	public boolean onCommand(CommandSender send, Command cmd, String str, String[] args) {
		Player pl = (Player)send;
		if (Arenas.playerInArena(pl)) {
			if (Arenas.getPlayerArena(pl).getGameState() == GameState.INGAME)
			openKits(pl);	
		}		
		return false;
	}
	public void openKits(Player pl) {
		pl.openInventory(new KitInventory().getInventory());
	}
}
