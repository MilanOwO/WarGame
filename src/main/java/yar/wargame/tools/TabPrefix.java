package yar.wargame.tools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import yar.wargame.arenas.Arena;
import yar.wargame.teams.Team;

public class TabPrefix {

	public final String[] colors = {"a","b","c","9","e","d","f","0","1","2","3","4","5","6,","7","8","9"};
	static org.bukkit.scoreboard.Scoreboard board = Scoreboard.b;
	public void setDefaultPrefix(Player pl) {
		
			
		org.bukkit.scoreboard.Team t = board.getTeam(pl.getName());
		if (t == null) {
			t = board.registerNewTeam(pl.getName());
		}
		if (pl.isOp()) {
			t.setPrefix(Server.colorText("&c&lADMIN&e "));
		} else {
			t.setPrefix(Server.colorText("&6&lGUEST&f "));
		}
		
		t.addEntry(pl.getName());
		pl.setScoreboard(board);
	}
	public void setTeamPrefix(Player pl, Arena arena, Team team, int index) {
		
		
		org.bukkit.scoreboard.Team t = board.getTeam(""+arena.getName()+"."+team.getName());
		if (t == null) {
			t = board.registerNewTeam(""+arena.getName()+"."+team.getName());
		}
		t.setPrefix(Server.colorText("&"+colors[index]));
		
		t.addEntry(pl.getName());
		pl.setScoreboard(board);
	}
	
}
