package yar.wargame.tools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import yar.wargame.messages.MessageManager;
import yar.wargame.arenas.Arena;


public class Scoreboard {
	
	private static final String[] colors = {"a","b","c","9","e","d","f","0","1","2","3","4","5","6,","7","8","9"};
	static ScoreboardManager man = Bukkit.getScoreboardManager();
	static org.bukkit.scoreboard.Scoreboard b = man.getNewScoreboard();
	public static void addIngame(Player pl, Arena arena) {
		
		Team t = b.getTeam("WarGame");
		if (t == null) {
			t = b.registerNewTeam("WarGame");
		}
		
		Objective o = b.getObjective("WarGame");
		if (o == null) {
			o = b.registerNewObjective("WarGame", "dummy");
		} else {
			removeScoreBoard(pl);
			o = b.registerNewObjective("WarGame", "dummy");
		}
		o.setDisplayName(Server.colorText("&l&cWarGame"));
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		@SuppressWarnings("deprecation")
		Score score = o.getScore(Bukkit.getOfflinePlayer(Server.colorText(MessageManager.getPlayersInArenaScoreboard() +" &a&l"+arena.getPlayersNumber())));
		score.setScore(0);
		@SuppressWarnings("deprecation")
		Score score2 = o.getScore(Bukkit.getOfflinePlayer(Server.colorText(MessageManager.getArenasScoreboard())));
		score2.setScore(2);
		@SuppressWarnings("deprecation")
		Score score3 = o.getScore(Bukkit.getOfflinePlayer(Server.colorText("&c&l "+arena.getName())));
		score3.setScore(1);
		pl.setScoreboard(b);
	}
	@SuppressWarnings("deprecation")
	public static void addIngame(Player pl, Arena arena, int i, int teams, int towers) {

		Team t = b.getTeam("WarGame");
		if (t == null) {
			t = b.registerNewTeam("WarGame");
		}
		Objective o = b.getObjective("WarGame");
		if (o == null) {
			o = b.registerNewObjective("WarGame", "dummy");
		} else {
			removeScoreBoard(pl);
			o = b.registerNewObjective("WarGame", "dummy");
		}
		o.setDisplayName(Server.colorText(Server.getPrefix()));
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		
		int j = arena.getTeamNumber();
		int x = 0;
		Score score2 = o.getScore(Bukkit.getOfflinePlayer(Server.colorText(MessageManager.getTeamAliveScoreboard())));
		score2.setScore(j+1);
		for (yar.wargame.teams.Team team : arena.getTeams().getTeams()) {
			Score score3 = o.getScore(Bukkit.getOfflinePlayer(Server.colorText("    &"+colors[x]+team.getName()+ " &7[&e"+(team.getTowers().getTowers().size()-team.getTowersDestroyed().size())+"&7]"/**/)));
			score3.setScore(j);
			j--;
			x++;
		}
		Score score = o.getScore(Bukkit.getOfflinePlayer(Server.colorText(MessageManager.getGameEndScoreboard()+"&e "+i)));
		score.setScore(0);
		
		pl.setScoreboard(b);
	}
	public static void removeScoreBoard(Player pl){

		b.getObjective("WarGame").unregister();
		pl.setScoreboard(b);
	}

}
