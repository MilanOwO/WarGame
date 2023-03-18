package yar.wargame.weapons;

public enum WeaponType {
	
	PISTOL, ASSULT, SMG, SHOTGUN, SNIPER;
	
	private WeaponType type;

	public WeaponType getType() {
		return type;
	}

	public void setType(WeaponType type) {
		this.type = type;
	}
	
	public static WeaponType getType(String name) {
		for (WeaponType type : WeaponType.values()) {
			if (type.name().equals(name)) {
				return type;
			}
		}
		return null;
	}
}
