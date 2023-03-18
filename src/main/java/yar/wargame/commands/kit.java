package yar.wargame.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import yar.wargame.messages.MessageManager;
import yar.wargame.hu.Main;
import yar.wargame.kits.Kit;
import yar.wargame.kits.Kits;
import yar.wargame.tools.Server;

public class kit implements CommandExecutor{
	public void addCommand() {
		Bukkit.getPluginCommand("kit").setExecutor(this);
	}
	
	Main main = Main.getPlugin(Main.class);
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender send, Command cmd, String str, String[] args) {
		Player pl = (Player) send;
		if (!(pl.isOp()))return false;
		if (args.length == 2 && args[0].toLowerCase().equals("create")) {
			ArrayList<ItemStack> tools = new ArrayList<>();
			tools.add(new ItemStack(Material.APPLE, 20));
			tools.add(new ItemStack(Material.WOODEN_SWORD)); 
			Kits.create(new Kit(args[1], tools, Material.WOODEN_SWORD));
			Server.sendMessage(pl, MessageManager.getKitSuccesfullyCreatedMessage());
		} else if (args.length == 1) {
			Kits.giveKit(pl, args[0]);
		} else if (args.length == 2 &&  args[0].toLowerCase().equals("addtool") && pl.getItemInHand().getType() != Material.AIR) {
			try {
				if (pl.getItemInHand().getType() == Material.AIR) {
					Server.sendMessage(pl, MessageManager.getItemNotFoundMessage());	
					return false;
				}
				ItemStack item = pl.getItemInHand();
				Kits.addTool(new ItemStack(item.getType(), item.getAmount()), Kits.getKit(args[1]));
				Server.sendMessage(pl, MessageManager.getToolSuccesfullyAddMessage());
			} catch (NumberFormatException e) {
				Server.sendMessage(pl, MessageManager.getNotNumberErrorMessage());
			}
		} else if (args.length == 3 &&  args[0].toLowerCase().equals("addtool") && pl.getItemInHand().getType() != Material.AIR) {
			try {
				ItemStack item = pl.getItemInHand();
				Kits.addTool(new ItemStack(item.getType(), item.getAmount()), Kits.getKit(args[1]), Server.colorText(args[2]));
				Server.sendMessage(pl, MessageManager.getToolSuccesfullyAddMessage());
			} catch (NumberFormatException e) {
				Server.sendMessage(pl, MessageManager.getNotNumberErrorMessage());	
			}
		} else if (args.length == 2 &&  args[0].toLowerCase().equals("removetool") && pl.getItemInHand().getType() != Material.AIR) {
				if (pl.getItemInHand().getType() == Material.AIR) {
					Server.sendMessage(pl, MessageManager.getItemNotFoundMessage());	
					return false;
				}
				Material material = pl.getItemInHand().getType();
				Kits.removeTool(material, Kits.getKit(args[1]));
				Server.sendMessage(pl, MessageManager.getToolSuccesfullyRemoveMessage());
		} else if (args.length == 2 && args[0].toLowerCase().equals("seticon")) {
			if (pl.getItemInHand().getType() == Material.AIR) {
				Server.sendMessage(pl, MessageManager.getItemNotFoundMessage());	
			} else {
				Kits.setIcon(pl.getItemInHand().getType(), Kits.getKit(args[1]));
				Server.sendMessage(pl, MessageManager.getKitSeticonMessage());
			}
		} else {
			info(pl);
		}
		return false;
	}
	
	public void info(Player pl) {
		pl.sendMessage(Server.colorText(Server.getPrefix()));
		pl.sendMessage(Server.colorText(MessageManager.getKitAddToolHelpMessage()));
		pl.sendMessage(Server.colorText(MessageManager.getKitRemoveToolHelpMessage()));
		pl.sendMessage(Server.colorText(MessageManager.getKitSeticonHelpMessage()));
		pl.sendMessage(Server.colorText(Server.getPrefix()));
		
	}

}
