package yar.wargame.managers;

public enum GameState {
	
	LOBBY,INGAME,STOP;
	private GameState gameState;

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	


}
