package yar.wargame.messages;


import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import yar.wargame.hu.Main;

public class MessagesConfig {
	
	private static Main plugin = Main.getPlugin(Main.class);
	
	private static FileConfiguration config;
	private static File file;
	
	public  static void setup() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		setFile(new File(plugin.getDataFolder(), "message_"+MessageFileConfig.getConfig().getString("language")+".yml"));
		if (!getFile().exists()) {
			try {
				getFile().createNewFile();
				setConfig(YamlConfiguration.loadConfiguration(file));
				getConfig().set("anotherTeamSetupMessage", "&cNow setup an another team!");
				getConfig().set("arenaInfoCreateMessage", "&c /wargame create 'create and setup an arena!'");
				getConfig().set("arenaInfoLeaveMessage", "&c /wargame leave <arenaname> 'leave an arena'");
				getConfig().set("arenaInfoListMessage", "&c /wargame arenas 'list arenas'");
				getConfig().set("arenaInfoJoinMessage", "&c /wargame join <arenaname> 'join an arena'");
				getConfig().set("arenaIsStartedMessage", "&cSorry, but this arena has been started!");
				getConfig().set("arenaSetupMessage", "&aArena has been setupped!");
				getConfig().set("arenasMessage", "&9Arenas");
				getConfig().set("arenaSuccessfullyCreatedMessage", "&bArena successfully created!");
				getConfig().set("arenasScoreboard", "&eArena is:");
				getConfig().set("cantDamageTeammateMessage", "&bYou cant damage your teammate!");
				getConfig().set("chooseArenaMessage", "&cChoose an arena!");
				getConfig().set("chooseEquipmentMessage", "&6Choose a gun!");
				getConfig().set("chooseKitMessage", "&5Choose a kit!");
				getConfig().set("chooseTeamMessage", "Choose a team!");
				getConfig().set("equipmentMessage", "&cEquipment");
				getConfig().set("gameEndedMessage", "&4The game is over!");
				getConfig().set("gameEndMessage", "&7The game will over in ");
				getConfig().set("gameEndScoreboard", "&7The game will be end in: ");
				getConfig().set("gameStartedMessage", "&7The game has been started!");
				getConfig().set("gameStartMessage", "&7The game will be start in ");
				getConfig().set("gameTimeSetupMessage", "&cThe game time is successfully setupped!");
				getConfig().set("isJoinedAnArenaMessage", "&cYou already joined an arena!");
				getConfig().set("isJoinedThisArenaMessage", "You already joined this arena!");
				getConfig().set("itemNotFoundMessage", "&cThe item is not found!");
				getConfig().set("kitsMessage", "&4Kits");
				getConfig().set("kitAddToolHelpMessage", "&6 /kit addtool <kitname> 'add a tool to your kit wich in your hand' or '/kit addtool <kitname> <prefix> add a tool to your kit wich in your hand with a prefix what you write example \"&4&lKatana&6\"'");
				getConfig().set("kitNotFoundMessage", "&cKit not found!");
				getConfig().set("kitRemoveToolHelpMessage", "&6 /kit removetool <kitname> 'remove a tool to your kit wich in your hand'");
				getConfig().set("kitSeticonMessage", "&cThe icon succesfully setted!");
				getConfig().set("kitSeticonHelpMessage", "&6 /kit seticon <kitname> 'set an icon tool to your kit wich in your hand'");
				getConfig().set("kitSuccessfullyCreatedMessage", "&9Kit successfully created!");
				getConfig().set("joinGameMessage", "&7is joined the game");
				getConfig().set("joinGameMessage2", "&7we are waiting for players.");
				getConfig().set("lackOfPlayerMessage", "&bIn this arena not enough player.");
				getConfig().set("leftGameMessage", "&2You are left the game!");
				getConfig().set("lobbyCountdownTimeMessage", "&6LobbyCountdownTime successfully configured!");
				getConfig().set("lobbySpawnSetupMessage", "&6Lobby spawn successfully configured!");
				getConfig().set("nameSetupMessage", "&cThe name is setuped!");
				getConfig().set("notNumberErrorMessage", "&cPlease add a number!");
				getConfig().set("nowSetupLbcdMessage", "&aNow setup the lobby countdown time!");
				getConfig().set("nowSetupLobbySpawnMessage", "&aNow setup the lobby spawn!");
				getConfig().set("nowSetupGameTimeMessage","&aNow setup the game time!");
				getConfig().set("nowSetupTeamNumberMessage","&aNow setup the team number!");
				getConfig().set("nowSetupTeamPlayersNumberMessage", "&aNow setup the team players number!");
				getConfig().set("nowSetupTeamSpawnMessage", "&aNow setup the team spawn!");
				getConfig().set("nowSetupTowerMessage", "&aNow setup the towers!");
				getConfig().set("nowSetupTowerNumberMessage", "&aNow setup the tower number!");
				getConfig().set("playersInArenaScoreboard", "&7Players:");
				getConfig().set("playerKilledByPlayerMessage", "&4 is killed by ");
				getConfig().set("playerLeftMessage", "&4 is left the game!");
				getConfig().set("seconds", " &7seconds!");
				getConfig().set("teamAliveScoreboard", "&7Alive teams:");
				getConfig().set("teamDestroyedMessage", "&e is destroyed by: ");
				getConfig().set("teamIsFullMessage", "&eThe team is full!");
				getConfig().set("teamJoinMessage", "&eYou are joined to this team!");
				getConfig().set("teamNumberMessage", "&6Team number is successfully setuped!");
				getConfig().set("teamPlayersNumberMessage", "&6Team players number successfully setuped!");
				getConfig().set("teamSpawnpositionsetupMessage", "&6 spawn position is successfully setuped!");
				getConfig().set("teamsMessage", "&bTeams");
				getConfig().set("teamWinMessage", "&6 team is win the game!");
				getConfig().set("toolSuccessfullyAddMessage", "&6The tool is successfully added to the kit!");
				getConfig().set("toolSuccessfullyRemoveMessage", "&6The tool is succesfully removed from the kit!");
				getConfig().set("towerAliveScoreboard", "&7Alive towers: ");
				getConfig().set("towerDestroyedByPlayerMessage", "&6 tower is successfully destroyed by: ");
				getConfig().set("towerNumberMessage", "&6Tower number is succesfully setuped!");
				getConfig().set("towerSetupMessage", "&cTower ");
				getConfig().set("towerSetupMessage2", " &cis successfully setuped!");
				getConfig().set("weaponReloadMessage","&cReloading...");
				saveConfig();
				Bukkit.getServer().getConsoleSender().sendMessage("messageConfig.yml succesfully created!");
			} catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage("Error: weapons.yml file could not created!");
				
			}
		} else {
			Bukkit.getServer().getConsoleSender().sendMessage("messageConfig.yml succesfully loaded!");
			setConfig(YamlConfiguration.loadConfiguration(file));
		}
	}

	public static FileConfiguration getConfig() {
		return config;
	}

	private static void setConfig(FileConfiguration config) {
		MessagesConfig.config = config;
	}

	public static File getFile() {
		return file;
	}

	private static void setFile(File file) {
		MessagesConfig.file = file;
	}
	public static void saveConfig() {
		try {
			getConfig().save(file);
		} catch(IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(Color.RED+"Error: messageConfig.ymls file could not save.");
		}
	}
	public static void reloadConfig() {
		setConfig(YamlConfiguration.loadConfiguration(file));
	}
	
}

