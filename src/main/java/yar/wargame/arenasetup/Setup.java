package yar.wargame.arenasetup;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;


import yar.wargame.arenas.Arena;
import yar.wargame.arenas.Arenas;
import yar.wargame.hu.Main;
import yar.wargame.messages.MessageManager;
import yar.wargame.teams.Team;
import yar.wargame.teams.Tower;
import yar.wargame.tools.Server;

public class Setup {
	private Main main = Main.getPlugin(Main.class);
	private String name;
	private int lbcd;
	private int gameTime;
	private int teamNumber;
	private int teamPlayersNumber;
	private int towersNumber;
	private Location lobbyspawn;
	private ArrayList<Location> teamsSpawn = new ArrayList<>();
	private HashMap<Player, Arena> setupers = new HashMap<>();
	private Arena arena;
	
	public Setup(Arena arena) {
		this.arena=arena;
	}
	
	public void done(Player pl) {
		getSetupers().remove(pl);
		arena.setName(getName());
		arena.setGameTime(getGameTime());
		arena.setLobbyCountdownTime(getLbcd());
		arena.setTeamPlayersNumber(getTeamPlayersNumber());
		arena.setTeamNumber(getTeamNumber());
		arena.setTowersNumber(getTowersNumber());
		arena.setSpawnposition(getLobbyspawn());
		arena.setTeamsSpawn(getTeamsSpawn());
		main.saveConfig();
		arena.setSetupState(SetupState.STOP);
		Arenas.getArenas().remove(Arenas.getArena(pl.getName()));
		Arenas.add(arena);
	}

	public void addName(String name, Player pl) {		
		setName(name);
		arena.setSetupState(SetupState.LOBBYCOUNTDOWN);
		Server.sendMessage(pl, MessageManager.getNameSetupMessage());
		Server.sendMessage(pl, MessageManager.getNowSetupLbcdMessage());
		return;
		
	}
	
	public void addLobbyCountdown(int lbcd, Player pl) {
		try {
			this.setLbcd(lbcd);
			main.getConfig().set("arenas."+name+".lobbycountdowntime", lbcd);
			arena.setSetupState(SetupState.GAMETIME);
			Server.sendMessage(pl, MessageManager.getLobbyCountdownTimeMessage());
			Server.sendMessage(pl, MessageManager.getNowSetupGameTimeMessage());
		} catch(NumberFormatException e) {
			Server.sendMessage(pl, MessageManager.getNotNumberErrorMessage());
			return;
		} 
		return;
	}
	public void addGameTime(int gameTime, Player pl) {
		try {
			setGameTime(gameTime);
			main.getConfig().set("arenas."+name+".gametime", gameTime);
			arena.setSetupState(SetupState.TEAMNUMBER);
			Server.sendMessage(pl, MessageManager.getGameTimeSetupMessage());
			Server.sendMessage(pl, MessageManager.getNowSetupTeamNumberMessage());
		} catch(NumberFormatException e) {
			Server.sendMessage(pl, MessageManager.getNotNumberErrorMessage());
			return;
		}
		return;
	}
	
	public void addTeamNumber(int teamNumber, Player pl) {
		try {
			setTeamNumber(teamNumber);
			main.getConfig().set("arenas."+name+".teamNumber",teamNumber);
			arena.setSetupState(SetupState.TEAMPLAYERSNUMBER);
			Server.sendMessage(pl, MessageManager.getTeamNumberMessage());
			Server.sendMessage(pl, MessageManager.getNowSetupTeamPlayersNumnberMessage());
		} catch(NumberFormatException e){
			Server.sendMessage(pl, MessageManager.getNotNumberErrorMessage());
			return;
		}
		return;
	}
	public void addTeamPlayersNumber(int teamPlayersNumber, Player pl) {
		try {
			setTeamPlayersNumber(teamPlayersNumber);
			main.getConfig().set("arenas."+name+".teamPlayersNumber", teamPlayersNumber);		
			arena.setSetupState(SetupState.TOWERNUMBER);
			Server.sendMessage(pl, MessageManager.getTeamPlayersNumberMessage());
			Server.sendMessage(pl, MessageManager.getNowSetupTowerNumberMessage());
		} catch(NumberFormatException e){
			Server.sendMessage(pl, MessageManager.getNotNumberErrorMessage());
			return;
		}
		return;
	}
	
	public void addTowersNumber(int towersNumber, Player pl) {
		try {
			setTowersNumber(towersNumber);
			main.getConfig().set("arenas."+name+".towersNumber", towersNumber);	
			arena.setSetupState(SetupState.LOBBYSPAWN);
			Server.sendMessage(pl, MessageManager.getTowerNumberMessage());
			Server.sendMessage(pl, MessageManager.getNowSetupLobbySpawnMessage());
		}catch(NumberFormatException e){
			Server.sendMessage(pl, MessageManager.getNotNumberErrorMessage());
			return;
		}
		return;
	}
	public void addLobbySpawn(Location lobbySpawn) {
		main.getConfig().set("arenas."+name+".lobbyspawn", lobbySpawn);
		setLobbyspawn(lobbySpawn);
		arena.setSetupState(SetupState.TEAMSPAWN);
	}
	public void addTeamSpawn(Location teamSpawn) {
		if(teamsSpawn.size() < teamNumber) {
			teamsSpawn.add(teamSpawn);
			arena.getTeams().getTeams().add(new Team(teamPlayersNumber, "Team"+(teamsSpawn.size()), teamSpawn,arena));
			main.getConfig().set("arenas."+name+".teams."+teamsSpawn.size()+".spawn", teamSpawn);
			arena.setSetupState(SetupState.TOWERSPAWN);
			
		}
		else {
			return;
		}
	}
	public void addTowerSpawn(Player pl,Location towerSpawn) {
		if (arena.getTeams().getTeams().get(teamsSpawn.size()-1).getTowers().getTowers().size()<towersNumber) {
			arena.getTeams().getTeams().get(teamsSpawn.size()-1).getTowers().getTowers().add(new Tower(towerSpawn, towerSpawn.getBlock().getType()));
			main.getConfig().set("arenas."+name+".teams."+teamsSpawn.size()+".tower."+arena.getTeams().getTeams().get(teamsSpawn.size()-1).getTowers().getTowers().size()+".location", towerSpawn);
			main.getConfig().set("arenas."+name+".teams."+teamsSpawn.size()+".tower."+arena.getTeams().getTeams().get(teamsSpawn.size()-1).getTowers().getTowers().size()+".type", towerSpawn.getBlock().getType().name());
			Server.sendMessage(pl,MessageManager.getTowerSetupMessage()+arena.getTeams().getTeams().get(teamsSpawn.size()-1).getTowers().getTowers().size()+MessageManager.getTowerSetupMessage2());
		}
		
			
		if (teamsSpawn.size() == teamNumber&& arena.getTeams().getTeams().get(teamsSpawn.size()-1).getTowers().getTowers().size()==towersNumber){
			arena.getSetup().done(pl);
			Server.sendMessage(pl, MessageManager.getArenaSetupMessage());
			return;
		}
		if(arena.getTeams().getTeams().get(teamsSpawn.size()-1).getTowers().getTowers().size()==towersNumber && !(teamsSpawn.size() == teamNumber)) {
			Server.sendMessage(pl, MessageManager.getAnotherTeamSetupMessage());
			arena.setSetupState(SetupState.TEAMSPAWN);
		}
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGameTime() {
		return gameTime;
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}

	public int getLbcd() {
		return lbcd;
	}

	public void setLbcd(int lbcd) {
		this.lbcd = lbcd;
	}

	public int getTeamPlayersNumber() {
		return teamPlayersNumber;
	}

	public void setTeamPlayersNumber(int teamPlayersNumber) {
		this.teamPlayersNumber = teamPlayersNumber;
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public int getTowersNumber() {
		return towersNumber;
	}

	public void setTowersNumber(int towersNumber) {
		this.towersNumber = towersNumber;
	}

	public Location getLobbyspawn() {
		return lobbyspawn;
	}

	public void setLobbyspawn(Location lobbyspawn) {
		this.lobbyspawn = lobbyspawn;
	}

	public ArrayList<Location> getTeamsSpawn() {
		return teamsSpawn;
	}

	public void setTeamsSpawn(ArrayList<Location> teamsSpawn) {
		this.teamsSpawn = teamsSpawn;
	}

	public HashMap<Player, Arena> getSetupers() {
		return setupers;
	}

	public void setSetupers(HashMap<Player, Arena> setupers) {
		this.setupers = setupers;
	}

	public void setup(Player pl) {
		setupers.put(pl, arena);
		arena.setSetupState(SetupState.NAME);
	}

}
