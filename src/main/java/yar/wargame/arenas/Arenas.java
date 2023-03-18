package yar.wargame.arenas;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import yar.wargame.hu.Main;

public class Arenas {

	private static ArrayList<Arena> arenas = new ArrayList<>();

	public static ArrayList<Arena> getArenas() {
		return arenas;
	}

	// Ar�na l�trehoz�sa
	public static void create(Arena arena, Player pl) {
		arena.getSetup().setup(pl);
		Arenas.add(arena);

		
	}

	// Ar�na hozz�ada�sa az arenas-hoz
	public static void add(Arena arena) {
		arenas.add(arena);
	}

	// Keres�s az ar�na neve alapj�n
	public static Arena getArena(String name) {
		for (Arena arena : arenas) {
			if (arena.getName().equals(name)) {
				return arena;
			}
		}
		return null;
	}

	// Ar�n�k fel�p�t�se
	public static void build() {
		Main main = Main.getPlugin(Main.class);
		try {
			for (String str : main.getConfig().getConfigurationSection("arenas").getKeys(false)) {
				Location loc = (Location) main.getConfig().get("arenas." + str + ".lobbyspawn");
				Arena arena = new Arena(str, loc, main.getConfig().getInt("arenas." + str + ".lobbycountdowntime"),
						main.getConfig().getInt("arenas." + str + ".gametime"),
						main.getConfig().getInt("arenas." + str + ".teamNumber"),
						main.getConfig().getInt("arenas." + str + ".teamPlayersNumber"), 
						main.getConfig().getInt("arenas."+str+".towersNumber"));
				System.out.println(arena.getTowersNumber());
				Arenas.add(arena);
				arena.getTeams().build();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static boolean playerInArena(Player pl) {
		for (Arena arena : arenas) {
			for (Player player : arena.getPlayers()) {
				if (player == pl) {
					return true;
				}
			}
		}
		return false;
	}
	public static Arena getPlayerArena(Player player) {
		for (Arena arena : arenas) {
			for (Player pl : arena.getPlayers()) {
				if (player == pl) {
					return arena;
				}
			}
		}
		return null;
	}
}
