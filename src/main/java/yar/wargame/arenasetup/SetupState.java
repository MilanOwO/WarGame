package yar.wargame.arenasetup;

public enum SetupState {
	NAME,LOBBYCOUNTDOWN,GAMETIME,TEAMNUMBER,TEAMPLAYERSNUMBER,TOWERNUMBER,LOBBYSPAWN,TEAMSPAWN,TOWERSPAWN,STOP;
	private SetupState setupState;

	public SetupState getSetupState() {
		return setupState;
	}

	public void setSetupState(SetupState setupState) {
		this.setupState = setupState;
	}

	
}
