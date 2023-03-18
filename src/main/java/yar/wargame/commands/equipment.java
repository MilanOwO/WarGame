package yar.wargame.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import yar.wargame.arenas.Arenas;
import yar.wargame.hu.Main;
import yar.wargame.managers.GameState;
import yar.wargame.weapons.EquipmentInventory;

public class equipment implements CommandExecutor{
	public void addCommand() {
		Bukkit.getPluginCommand("equipment").setExecutor(this);
	}
	
	Main main = Main.getPlugin(Main.class);
	@Override
	public boolean onCommand(CommandSender send, Command cmd, String str, String[] args) {
		Player pl = (Player) send;
		if (Arenas.getPlayerArena(pl) == null)
			return false;
		if (Arenas.getPlayerArena(pl).getGameState() == GameState.INGAME)
			pl.openInventory(new EquipmentInventory().getInventory(pl));
		return false;
	}

}
