package yar.wargame.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arena;
import yar.wargame.arenas.Arenas;
import yar.wargame.hu.Main;
import yar.wargame.managers.Game;
import yar.wargame.tools.Server;

public class wargame implements CommandExecutor{
	public void addCommand() {
		Bukkit.getPluginCommand("wargame").setExecutor(this);
	}
	
	Main main = Main.getPlugin(Main.class);
	@Override
	public boolean onCommand(CommandSender send, Command cmd, String str, String[] args) {
		Player pl = (Player) send; 
		if (args.length == 0 ) {
			info(pl);
		}
		else if (args.length == 1 && args[0].equals("create")) {
			if (!(pl.isOp()))return false;
			Arenas.create(new Arena(pl.getName(), null, 0, 0, 0, 0, 0),pl);			
			Server.sendMessage(pl, MessageManager.getArenaSuccesfullyCreatedMessage());
		}
		
		else if (args.length == 2 && args[0].equals("join")) {
			Arena arena = Arenas.getArena(args[1]);
			
			Game.join(arena, pl);
		}
		else if (args.length == 2 && args[0].equals("leave")) {
			Arena arena = Arenas.getArena(args[1]);
			
			Game.leave(arena, pl);
		}
		else if (args.length == 1 && args[0].equals("arenas")) {
			for (Arena arena : Arenas.getArenas() ) {
			pl.sendMessage(arena.getName());
			}
		}
		
		return false;
	}
	public void info(Player pl) {
		pl.sendMessage(Server.colorText(Server.getPrefix()));
		pl.sendMessage(Server.colorText(MessageManager.getArenaInfoCreateMessage()));
		pl.sendMessage(Server.colorText(MessageManager.getArenaInfoJoinMessage()));
		pl.sendMessage(Server.colorText(MessageManager.getArenaInfoLeaveMessage()));
		pl.sendMessage(Server.colorText(MessageManager.getArenaInfoListMessage()));
		pl.sendMessage(Server.colorText(Server.getPrefix()));
	}
	
}
