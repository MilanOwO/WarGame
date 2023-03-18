package yar.wargame.arenas; 

import java.util.ArrayList;

import org.bukkit.Location; 
import org.bukkit.entity.Player;

import yar.wargame.arenasetup.Setup;
import yar.wargame.arenasetup.SetupState;
import yar.wargame.managers.GameManager;
import yar.wargame.managers.GameState;
import yar.wargame.managers.LobbyCountdown;
import yar.wargame.teams.Team;
import yar.wargame.teams.Teams;
import yar.wargame.weapons.Equipments;

public class Arena {
	
	//Ar�na neve
	private String name;
	
	//J�t�k ideje
	private int gameTime;
	//Lobby id�
	private int lobbyCountdownTime;
	//A j�t�k st�tusza
	private GameState gameState = GameState.LOBBY;
	//J�t�kosok az ar�n�ban
	private ArrayList<Player> players = new ArrayList<Player>();
	//Spawn poz�ci�
	private Location spawnposition;
	//LobbyCountdown class v�ltoz�ja
	private LobbyCountdown lobbyCountdown = new LobbyCountdown(this);
	//GameManager class v�ltoz�ja
	private GameManager gameManager = new GameManager(this);
	//Csapatok sz�ma
	private int teamNumber;
	//Csapatok
	private Teams teams = new Teams(this);
	//Csapatokban a f�r�hely
	private int teamPlayersNumber;
	//Maximum j�t�kos
	private int maximumplayer;
	//Minium j�t�kos
	private int minimumplayer;
	//Setup class v�ltoz�ja
	private Setup setup = new Setup(this);
	//Setup st�tusz
	private SetupState setupState = SetupState.STOP;
	//Tornyok sz�ma
	private int towersNumber;
	//Csapatok spawnja
	private ArrayList<Location> teamsSpawn; 
	//Elpuszt�tott csapatok
	private ArrayList<Team> teamsDestroyed = new ArrayList<>();
	//Eszk�zt�r
	private Equipments equipments = new Equipments(this);
	
	public Arena(String name, Location spawnposition,int lobbyCountdownTime, int gameTime, int teamNumber, int teamPlayersNumber, int towersNumber) {
		setGameTime(gameTime);
		setLobbyCountdownTime(lobbyCountdownTime);
		setName(name);
		setSpawnposition(spawnposition);
		setTeamNumber(teamNumber);
		setTeamPlayersNumber(teamPlayersNumber);
		setMaximumplayer(teamNumber*teamPlayersNumber);
		setMinimumplayer(maximumplayer/2);
		setTowersNumber(towersNumber);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaximumplayer() {
		return maximumplayer;
	}

	public void setMaximumplayer(int maximumplayer) {
		this.maximumplayer = maximumplayer;
	}

	public int getMinimumplayer() {
		return minimumplayer;
	}

	public void setMinimumplayer(int minimumplayer) {
		this.minimumplayer = minimumplayer;
	}

	public Location getSpawnposition() {
		return spawnposition;
	}

	public void setSpawnposition(Location spawnposition) {
		this.spawnposition = spawnposition;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public int getPlayersNumber() {
		return players.size();
	}

	public int getLobbyCountdownTime() {
		return lobbyCountdownTime;
	}

	public void setLobbyCountdownTime(int lobbyCountdownTime) {
		this.lobbyCountdownTime = lobbyCountdownTime;
	}

	public int getGameTime() {
		return gameTime;
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public LobbyCountdown getLobbyCountdown() {
		return lobbyCountdown;
	}

	public GameManager getGameManager() {
		return gameManager;
	}

	
	public void setDefault() {
		for (Team team : getTeams().getTeams()) {
			team.setDefault();
		}
		setTeamsDestroyed(new ArrayList<Team>());
		players = new ArrayList<>();
		setGameState(GameState.LOBBY);
		getLobbyCountdown().setDefault();
		getGameManager().setDefault();
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public Teams getTeams() {
		return teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
	}

	public int getTeamPlayersNumber() {
		return teamPlayersNumber;
	}

	public void setTeamPlayersNumber(int teamPlayersNumber) {
		this.teamPlayersNumber = teamPlayersNumber;
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

	public SetupState getSetupState() {
		return setupState;
	}

	public void setSetupState(SetupState setupState) {
		this.setupState = setupState;
	}

	public int getTowersNumber() {
		return towersNumber;
	}

	public void setTowersNumber(int towersNumber) { 
		this.towersNumber = towersNumber;
	}

	public ArrayList<Location> getTeamsSpawn() {
		return teamsSpawn;
	}

	public void setTeamsSpawn(ArrayList<Location> teamsSpawn) {
		this.teamsSpawn = teamsSpawn;
	}

	public ArrayList<Team> getTeamsDestroyed() {
		return teamsDestroyed;
	}

	public void setTeamsDestroyed(ArrayList<Team> teamsDestroyed) {
		this.teamsDestroyed = teamsDestroyed;
	}
	public void destroyTeam(Team team) {
		team.setDestroyed(true); 
		getTeamsDestroyed().add(team);
	}

	public Equipments getEquipments() {
		return equipments;
	}

	public void setEquipments(Equipments equipments) {
		this.equipments = equipments;
	}
}
