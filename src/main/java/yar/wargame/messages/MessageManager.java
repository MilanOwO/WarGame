package yar.wargame.messages;

import org.bukkit.configuration.file.FileConfiguration;

public class MessageManager {
	
	private static FileConfiguration config = MessagesConfig.getConfig();
	
	private static String serverName = MessageFileConfig.getConfig().getString("serverName");
	private static String serverPrefix = MessageFileConfig.getConfig().getString("serverPrefix");
	private static String arenasMessage = config.getString("arenasMessage");
	private static String arenaSetupMessage = config.getString("arenaSetupMessage");
	private static String anotherTeamSetupMessage = config.getString("anotherTeamSetupMessage");
	private static String towerSetupMessage = config.getString("towerSetupMessage");
	private static String towerSetupMessage2 = config.getString("towerSetupMessage2");
	private static String kitSuccesfullyCreatedMessage = config.getString("kitSuccessfullyCreatedMessage");
	private static String itemNotFoundMessage = config.getString("itemNotFoundMessage");
	private static String toolSuccesfullyAddMessage = config.getString("toolSuccessfullyAddMessage");
	private static String toolSuccesfullyRemoveMessage = config.getString("toolSuccessfullyRemoveMessage");
	private static String notNumberErrorMessage = config.getString("notNumberErrorMessage");
	private static String arenaSuccesfullyCreatedMessage = config.getString("arenaSuccessfullyCreatedMessage");
	private static String arenaInfoJoinMessage = config.getString("arenaInfoJoinMessage");
	private static String arenaInfoCreateMessage = config.getString("arenaInfoCreateMessage");
	private static String arenaInfoLeaveMessage = config.getString("arenaInfoLeaveMessage");
	private static String arenaInfoListMessage = config.getString("arenaInfoListMessage");
	private static String choseArenaMessage = config.getString("chooseArenaMessage");
	private static String choseEquipmentMessage = config.getString("chooseEquipmentMessage");
	private static String towerDestroyedByPlayerMessage = config.getString("towerDestroyedByPlayerMessage");
	private static String teamDestroyedMessage = config.getString("teamDestroyedMessage");
	private static String teamWinMessage = config.getString("teamWinMessage");
	private static String playerKilledByPlayerMessage = config.getString("playerKilledByPlayerMessage");
	private static String cantDamageTeammateMessage = config.getString("cantDamageTeammateMessage");
	private static String teamSpawnpositionsetupMessage = config.getString("teamSpawnpositionsetupMessage"); 
	private static String nowSetupTowerMessaeg = config.getString("nowSetupTowerMessage");
	private static String lobbySpawnSetupMessage = config.getString("lobbySpawnSetupMessage");
	private static String nowSetupTeamSpawnMessage = config.getString("nowSetupTeamSpawnMessage");
	private static String nameSetupMessage = config.getString("nameSetupMessage");
	private static String nowSetupLbcdMessage = config.getString("nowSetupLbcdMessage");
	private static String lobbyCountdownTimeMessage = config.getString("lobbyCountdownTimeMessage");
	private static String nowSetupGameTimeMessage = config.getString("nowSetupGameTimeMessage");
	private static String gameTimeSetupMessage = config.getString("gameTimeSetupMessage");
	private static String nowSetupTeamNumberMessage = config.getString("nowSetupTeamNumberMessage");
	private static String teamNumberMessage = config.getString("teamNumberMessage");
	private static String nowSetupTowerNumberMessage = config.getString("nowSetupTowerNumberMessage");
	private static String towerNumberMessage = config.getString("towerNumberMessage");
	private static String nowSetupTeamPlayersNumnberMessage = config.getString("nowSetupTeamPlayersNumberMessage");
	private static String teamPlayersNumberMessage = config.getString("teamPlayersNumberMessage");
	private static String nowSetupLobbySpawnMessage = config.getString("nowSetupLobbySpawnMessage");
	private static String choseTeamMessage = config.getString("chooseTeamMessage");
	private static String leftGameMessage = config.getString("leftGameMessage");
	private static String playerLeftMessage = config.getString("playerLeftMessage");
	private static String joinGameMessage = config.getString("joinGameMessage");
	private static String joinGameMessage2 = config.getString("joinGameMessage2");
	private static String lackOfPlayerMessage = config.getString("lackOfPlayerMessage");
	private static String choseKitMessage = config.getString("chooseKitMessage");
	private static String gameEndMessage = config.getString("gameEndMessage");
	private static String gameEndedMessage = config.getString("gameEndedMessage");
	private static String seconds = config.getString("seconds");
	private static String gameStartMessage = config.getString("gameStartMessage");
	private static String gameStartedMessage = config.getString("gameStartedMessage");
	private static String arenaIsFullMessage = config.getString("arenaIsFullMessage");
	private static String teamIsFullMessage = config.getString("teamIsFullMessage");
	private static String isJoinedAnArenaMessage = config.getString("isJoinedAnArenaMessage");
	private static String isJoinedThisArenaMessage = config.getString("isJoinedThisArenaMessage");
	private static String arenaIsStartedMessage = config.getString("arenaIsStartedMessage");
	private static String teamJoinMessage = config.getString("teamJoinMessage");
	private static String kitsMessage = config.getString("kitsMessage");
	private static String gameEndScoreboard = config.getString("gameEndScoreboard");
	private static String teamAliveScoreboard = config.getString("teamAliveScoreboard");
	private static String towerAliveScoreboard = config.getString("towerAliveScoreboard");
	private static String arenasScoreboard = config.getString("arenasScoreboard");
	private static String playersInArenaScoreboard = config.getString("playersInArenaScoreboard");
	private static String teamsMessage = config.getString("teamsMessage");
	private static String equipmentMessage = config.getString("equipmentMessage");
	private static String weaponReloadMessage = config.getString("weaponReloadMessage");
	private static String kitAddToolHelpMessage = config.getString("kitAddToolHelpMessage");
	private static String kitRemoveToolHelpMessage = config.getString("kitRemoveToolHelpMessage");
	private static String kitSeticonMessage = config.getString("kitSeticonMessage");
	private static String kitSeticonHelpMessage = config.getString("kitSeticonHelpMessage");
	private static String kitNotFoundMessage = config.getString("kitNotFoundMessage");
	
	public static String getArenasMessage() {
		return arenasMessage;
	}

	public static void setArenasMessage(String arenasMessage) {
		MessageManager.arenasMessage = arenasMessage;
	}

	public static String getTowerSetupMessage() {
		return towerSetupMessage;
	}

	public static void setTowerSetupMessage(String towerSetupMessage) {
		MessageManager.towerSetupMessage = towerSetupMessage;
	}

	public static String getTowerSetupMessage2() {
		return towerSetupMessage2;
	}

	public static void setTowerSetupMessage2(String towerSetupMessage2) {
		MessageManager.towerSetupMessage2 = towerSetupMessage2;
	}

	public static String getServerName() {
		return serverName;
	}

	public static void setServerName(String serverName) {
		MessageManager.serverName = serverName;
	}

	public static String getServerPrefix() {
		return serverPrefix;
	}

	public static void setServerPrefix(String serverPrefix) {
		MessageManager.serverPrefix = serverPrefix;
	}

	public static String getArenaSetupMessage() {
		return arenaSetupMessage;
	}

	public static void setArenaSetupMessage(String arenaSetupMessage) {
		MessageManager.arenaSetupMessage = arenaSetupMessage;
	}

	public static String getAnotherTeamSetupMessage() {
		return anotherTeamSetupMessage;
	}

	public static void setAnotherTeamSetupMessage(String anotherTeamSetupMessage) {
		MessageManager.anotherTeamSetupMessage = anotherTeamSetupMessage;
	}

	public static String getKitSuccesfullyCreatedMessage() {
		return kitSuccesfullyCreatedMessage;
	}

	public static void setKitSuccesfullyCreatedMessage(String kitSuccesfullyCreatedMessage) {
		MessageManager.kitSuccesfullyCreatedMessage = kitSuccesfullyCreatedMessage;
	}

	public static String getItemNotFoundMessage() {
		return itemNotFoundMessage;
	}

	public static void setItemNotFoundMessage(String itemNotFoundMessage) {
		MessageManager.itemNotFoundMessage = itemNotFoundMessage;
	}

	public static String getToolSuccesfullyAddMessage() {
		return toolSuccesfullyAddMessage;
	}

	public static void setToolSuccesfullyAddMessage(String toolSuccesfullyAddMessage) {
		MessageManager.toolSuccesfullyAddMessage = toolSuccesfullyAddMessage;
	}

	public static String getToolSuccesfullyRemoveMessage() {
		return toolSuccesfullyRemoveMessage;
	}

	public static void setToolSuccesfullyRemoveMessage(String toolSuccesfullyRemoveMessage) {
		MessageManager.toolSuccesfullyRemoveMessage = toolSuccesfullyRemoveMessage;
	}

	public static String getNotNumberErrorMessage() {
		return notNumberErrorMessage;
	}

	public static void setNotNumberErrorMessage(String notNumberErrorMessage) {
		MessageManager.notNumberErrorMessage = notNumberErrorMessage;
	}

	public static String getArenaSuccesfullyCreatedMessage() {
		return arenaSuccesfullyCreatedMessage;
	}

	public static void setArenaSuccesfullyCreatedMessage(String arenaSuccesfullyCreatedMessage) {
		MessageManager.arenaSuccesfullyCreatedMessage = arenaSuccesfullyCreatedMessage;
	}

	public static String getArenaInfoJoinMessage() {
		return arenaInfoJoinMessage;
	}

	public static void setArenaInfoJoinMessage(String arenaInfoJoinMessage) {
		MessageManager.arenaInfoJoinMessage = arenaInfoJoinMessage;
	}

	public static String getArenaInfoCreateMessage() {
		return arenaInfoCreateMessage;
	}

	public static void setArenaInfoCreateMessage(String arenaInfoCreateMessage) {
		MessageManager.arenaInfoCreateMessage = arenaInfoCreateMessage;
	}

	public static String getArenaInfoLeaveMessage() {
		return arenaInfoLeaveMessage;
	}

	public static void setArenaInfoLeaveMessage(String arenaInfoLeaveMessage) {
		MessageManager.arenaInfoLeaveMessage = arenaInfoLeaveMessage;
	}

	public static String getArenaInfoListMessage() {
		return arenaInfoListMessage;
	}

	public static void setArenaInfoListMessage(String arenaInfoListMessage) {
		MessageManager.arenaInfoListMessage = arenaInfoListMessage;
	}

	public static String getChoseArenaMessage() {
		return choseArenaMessage;
	}

	public static void setChoseArenaMessage(String choseArenaMessage) {
		MessageManager.choseArenaMessage = choseArenaMessage;
	}

	public static String getChoseEquipmentMessage() {
		return choseEquipmentMessage;
	}

	public static void setChoseEquipmentMessage(String choseEquipmentMessage) {
		MessageManager.choseEquipmentMessage = choseEquipmentMessage;
	}

	public static String getTeamDestroyedMessage() {
		return teamDestroyedMessage;
	}

	public static void setTeamDestroyedMessage(String teamDestroyedMessage) {
		MessageManager.teamDestroyedMessage = teamDestroyedMessage;
	}

	public static String getTeamWinMessage() {
		return teamWinMessage;
	}

	public static void setTeamWinMessage(String teamWinMessage) {
		MessageManager.teamWinMessage = teamWinMessage;
	}

	

	public static String getPlayerKilledByPlayerMessage() {
		return playerKilledByPlayerMessage;
	}

	public static void setPlayerKilledByPlayerMessage(String playerKilledByPlayerMessage) {
		MessageManager.playerKilledByPlayerMessage = playerKilledByPlayerMessage;
	}

	public static String getTowerDestroyedByPlayerMessage() {
		return towerDestroyedByPlayerMessage;
	}

	public static void setTowerDestroyedByPlayerMessage(String towerDestroyedByPlayerMessage) {
		MessageManager.towerDestroyedByPlayerMessage = towerDestroyedByPlayerMessage;
	}

	public static String getCantDamageTeammateMessage() {
		return cantDamageTeammateMessage;
	}

	public static void setCantDamageTeammateMessage(String cantDamageTeammateMessage) {
		MessageManager.cantDamageTeammateMessage = cantDamageTeammateMessage;
	}

	public static String getTeamSpawnpositionsetupMessage() {
		return teamSpawnpositionsetupMessage;
	}

	public static void setTeamSpawnpositionsetupMessage(String teamSpawnpositionsetupMessage) {
		MessageManager.teamSpawnpositionsetupMessage = teamSpawnpositionsetupMessage;
	}

	public static String getNowSetupTowerMessaeg() {
		return nowSetupTowerMessaeg;
	}

	public static void setNowSetupTowerMessaeg(String nowSetupTowerMessaeg) {
		MessageManager.nowSetupTowerMessaeg = nowSetupTowerMessaeg;
	}

	public static String getLobbySpawnSetupMessage() {
		return lobbySpawnSetupMessage;
	}

	public static void setLobbySpawnSetupMessage(String lobbySpawnSetupMessage) {
		MessageManager.lobbySpawnSetupMessage = lobbySpawnSetupMessage;
	}

	public static String getNowSetupTeamSpawnMessage() {
		return nowSetupTeamSpawnMessage;
	}

	public static void setNowSetupTeamSpawnMessage(String nowSetupTeamSpawnMessage) {
		MessageManager.nowSetupTeamSpawnMessage = nowSetupTeamSpawnMessage;
	}

	public static String getNameSetupMessage() {
		return nameSetupMessage;
	}

	public static void setNameSetupMessage(String nameSetupMessage) {
		MessageManager.nameSetupMessage = nameSetupMessage;
	}

	public static String getNowSetupLbcdMessage() {
		return nowSetupLbcdMessage;
	}

	public static void setNowSetupLbcdMessage(String nowSetupLbcdMessage) {
		MessageManager.nowSetupLbcdMessage = nowSetupLbcdMessage;
	}

	public static String getLobbyCountdownTimeMessage() {
		return lobbyCountdownTimeMessage;
	}

	public static void setLobbyCountdownTimeMessage(String lobbyCountdownTimeMessage) {
		MessageManager.lobbyCountdownTimeMessage = lobbyCountdownTimeMessage;
	}

	public static String getNowSetupGameTimeMessage() {
		return nowSetupGameTimeMessage;
	}

	public static void setNowSetupGameTimeMessage(String nowSetupGameTimeMessage) {
		MessageManager.nowSetupGameTimeMessage = nowSetupGameTimeMessage;
	}

	public static String getGameTimeSetupMessage() {
		return gameTimeSetupMessage;
	}

	public static void setGameTimeSetupMessage(String gameTimeSetupMessage) {
		MessageManager.gameTimeSetupMessage = gameTimeSetupMessage;
	}

	public static String getNowSetupTeamNumberMessage() {
		return nowSetupTeamNumberMessage;
	}

	public static void setNowSetupTeamNumberMessage(String nowSetupTeamNumberMessage) {
		MessageManager.nowSetupTeamNumberMessage = nowSetupTeamNumberMessage;
	}

	public static String getTeamNumberMessage() {
		return teamNumberMessage;
	}

	public static void setTeamNumberMessage(String teamNumberMessage) {
		MessageManager.teamNumberMessage = teamNumberMessage;
	}

	public static String getNowSetupTowerNumberMessage() {
		return nowSetupTowerNumberMessage;
	}

	public static void setNowSetupTowerNumberMessage(String nowSetupTowerNumberMessage) {
		MessageManager.nowSetupTowerNumberMessage = nowSetupTowerNumberMessage;
	}

	public static String getTowerNumberMessage() {
		return towerNumberMessage;
	}

	public static void setTowerNumberMessage(String towerNumberMessage) {
		MessageManager.towerNumberMessage = towerNumberMessage;
	}

	public static String getNowSetupTeamPlayersNumnberMessage() {
		return nowSetupTeamPlayersNumnberMessage;
	}

	public static void setNowSetupTeamPlayersNumnberMessage(String nowSetupTeamPlayersNumnberMessage) {
		MessageManager.nowSetupTeamPlayersNumnberMessage = nowSetupTeamPlayersNumnberMessage;
	}

	public static String getTeamPlayersNumberMessage() {
		return teamPlayersNumberMessage;
	}

	public static void setTeamPlayersNumberMessage(String teamPlayersNumberMessage) {
		MessageManager.teamPlayersNumberMessage = teamPlayersNumberMessage;
	}

	public static String getNowSetupLobbySpawnMessage() {
		return nowSetupLobbySpawnMessage;
	}

	public static void setNowSetupLobbySpawnMessage(String nowSetupLobbySpawnMessage) {
		MessageManager.nowSetupLobbySpawnMessage = nowSetupLobbySpawnMessage;
	}

	public static String getChoseTeamMessage() {
		return choseTeamMessage;
	}

	public static void setChoseTeamMessage(String choseTeamMessage) {
		MessageManager.choseTeamMessage = choseTeamMessage;
	}

	public static String getLeftGameMessage() {
		return leftGameMessage;
	}

	public static void setLeftGameMessage(String leftGameMessage) {
		MessageManager.leftGameMessage = leftGameMessage;
	}

	public static String getPlayerLeftMessage() {
		return playerLeftMessage;
	}

	public static void setPlayerLeftMessage(String playerLeftMessage) {
		MessageManager.playerLeftMessage = playerLeftMessage;
	}

	public static String getJoinGameMessage() {
		return joinGameMessage;
	}

	public static void setJoinGameMessage(String joinGameMessage) {
		MessageManager.joinGameMessage = joinGameMessage;
	}

	public static String getJoinGameMessage2() {
		return joinGameMessage2;
	}

	public static void setJoinGameMessage2(String joinGameMessage2) {
		MessageManager.joinGameMessage2 = joinGameMessage2;
	}

	public static String getLackOfPlayerMessage() {
		return lackOfPlayerMessage;
	}

	public static void setLackOfPlayerMessage(String lackOfPlayerMessage) {
		MessageManager.lackOfPlayerMessage = lackOfPlayerMessage;
	}

	public static String getChoseKitMessage() {
		return choseKitMessage;
	}

	public static void setChoseKitMessage(String choseKitMessage) {
		MessageManager.choseKitMessage = choseKitMessage;
	}

	public static String getGameEndMessage() {
		return gameEndMessage;
	}

	public static void setGameEndMessage(String gameEndMessage) {
		MessageManager.gameEndMessage = gameEndMessage;
	}

	public static String getGameEndedMessage() {
		return gameEndedMessage;
	}

	public static void setGameEndedMessage(String gameEndedMessage) {
		MessageManager.gameEndedMessage = gameEndedMessage;
	}

	public static String getSeconds() {
		return seconds;
	}

	public static void setSeconds(String seconds) {
		MessageManager.seconds = seconds;
	}

	public static String getGameStartMessage() {
		return gameStartMessage;
	}

	public static void setGameStartMessage(String gameStartMessage) {
		MessageManager.gameStartMessage = gameStartMessage;
	}

	public static String getGameStartedMessage() {
		return gameStartedMessage;
	}

	public static void setGameStartedMessage(String gameStartedMessage) {
		MessageManager.gameStartedMessage = gameStartedMessage;
	}

	public static String getArenaIsFullMessage() {
		return arenaIsFullMessage;
	}

	public static void setArenaIsFullMessage(String arenaIsFullMessage) {
		MessageManager.arenaIsFullMessage = arenaIsFullMessage;
	}

	public static String getTeamIsFullMessage() {
		return teamIsFullMessage;
	}

	public static void setTeamIsFullMessage(String teamIsFullMessage) {
		MessageManager.teamIsFullMessage = teamIsFullMessage;
	}

	public static String getIsJoinedAnArenaMessage() {
		return isJoinedAnArenaMessage;
	}

	public static void setIsJoinedAnArenaMessage(String isJoinedAnArenaMessage) {
		MessageManager.isJoinedAnArenaMessage = isJoinedAnArenaMessage;
	}

	public static String getIsJoinedThisArenaMessage() {
		return isJoinedThisArenaMessage;
	}

	public static void setIsJoinedThisArenaMessage(String isJoinedThisArenaMessage) {
		MessageManager.isJoinedThisArenaMessage = isJoinedThisArenaMessage;
	}

	public static String getArenaIsStartedMessage() {
		return arenaIsStartedMessage;
	}

	public static void setArenaIsStartedMessage(String arenaIsStartedMessage) {
		MessageManager.arenaIsStartedMessage = arenaIsStartedMessage;
	}

	public static String getTeamJoinMessage() {
		return teamJoinMessage;
	}

	public static void setTeamJoinMessage(String teamJoinMessage) {
		MessageManager.teamJoinMessage = teamJoinMessage;
	}

	public static String getKitsMessage() {
		return kitsMessage;
	}

	public static void setKitsMessage(String kitsMessage) {
		MessageManager.kitsMessage = kitsMessage;
	}

	public static String getGameEndScoreboard() {
		return gameEndScoreboard;
	}

	public static void setGameEndScoreboard(String gameEndScoreboard) {
		MessageManager.gameEndScoreboard = gameEndScoreboard;
	}

	public static String getTeamAliveScoreboard() {
		return teamAliveScoreboard;
	}

	public static void setTeamAliveScoreboard(String teamAliveScoreboard) {
		MessageManager.teamAliveScoreboard = teamAliveScoreboard;
	}

	public static String getTowerAliveScoreboard() {
		return towerAliveScoreboard;
	}

	public static void setTowerAliveScoreboard(String towerAliveScoreboard) {
		MessageManager.towerAliveScoreboard = towerAliveScoreboard;
	}

	public static String getArenasScoreboard() {
		return arenasScoreboard;
	}

	public static void setArenasScoreboard(String arenasScoreboard) {
		MessageManager.arenasScoreboard = arenasScoreboard;
	}

	public static String getPlayersInArenaScoreboard() {
		return playersInArenaScoreboard;
	}

	public static void setPlayersInArenaScoreboard(String playersInArenaScoreboard) {
		MessageManager.playersInArenaScoreboard = playersInArenaScoreboard;
	}

	public static String getTeamsMessage() {
		return teamsMessage;
	}

	public static void setTeamsMessage(String teamsMessage) {
		MessageManager.teamsMessage = teamsMessage;
	}

	public static String getEquipmentMessage() {
		return equipmentMessage;
	}

	public static void setEquipmentMessage(String equipmentMessage) {
		MessageManager.equipmentMessage = equipmentMessage;
	}

	public static String getWeaponReloadMessage() {
		return weaponReloadMessage;
	}

	public static void setWeaponReloadMessage(String weaponReloadMessage) {
		MessageManager.weaponReloadMessage = weaponReloadMessage;
	}


	public static String getKitAddToolHelpMessage() {
		return kitAddToolHelpMessage;
	}

	public static void setKitAddToolHelpMessage(String kitAddToolHelpMessage) {
		MessageManager.kitAddToolHelpMessage = kitAddToolHelpMessage;
	}

	public static String getKitRemoveToolHelpMessage() {
		return kitRemoveToolHelpMessage;
	}

	public static void setKitRemoveToolHelpMessage(String kitRemoveToolHelpMessage) {
		MessageManager.kitRemoveToolHelpMessage = kitRemoveToolHelpMessage;
	}

	public static String getKitSeticonMessage() {
		return kitSeticonMessage;
	}

	public static void setKitSeticonMessage(String kitSeticonMessage) {
		MessageManager.kitSeticonMessage = kitSeticonMessage;
	}

	public static String getKitSeticonHelpMessage() {
		return kitSeticonHelpMessage;
	}

	public static void setKitSeticonHelpMessage(String kitSeticonHelpMessage) {
		MessageManager.kitSeticonHelpMessage = kitSeticonHelpMessage;
	}

	public static String getKitNotFoundMessage() {
		return kitNotFoundMessage;
	} 

	public static void setKitNotFoundMessage(String kitNotFoundMessage) {
		MessageManager.kitNotFoundMessage = kitNotFoundMessage;
	}

}
