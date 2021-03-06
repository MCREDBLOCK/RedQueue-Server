package rygb.tech.queueserver.mccore.functions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class CreateScoreboard {

    public static Objective o;
    public static Scoreboard normal() {
        //create scoreboard
        Scoreboard b = Bukkit.getScoreboardManager().getNewScoreboard();

        String s1 = ChatColor.translateAlternateColorCodes('&', "&4&lQUEUE");
        Objective o = b.registerNewObjective("QUEUE", "dummy", s1);

        //set display slot
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(s1);

        //bottom line
        String line = ChatColor.translateAlternateColorCodes('&', "&7&m---------------------");
        Score line1 = o.getScore(line);
        line1.setScore(0);

        //player count
        Team playercount = b.registerNewTeam("playercount");
        playercount.addEntry(ChatColor.RED + "" + ChatColor.GRAY);
        playercount.setPrefix(ChatColor.translateAlternateColorCodes('&', "&c" + Bukkit.getOnlinePlayers().size() + "&7/" + Bukkit.getMaxPlayers()));
        o.getScore(ChatColor.RED + "" + ChatColor.GRAY).setScore(1);

        //players
        String playerslineb = ChatColor.translateAlternateColorCodes('&', "&4&lPlayers in Queue");
        Score playersline = o.getScore(playerslineb);
        playersline.setScore(2);

        //top line
        String line2 = ChatColor.translateAlternateColorCodes('&', "&4&l&7&m---------------------");
        Score line2line = o.getScore(line2);
        line2line.setScore(3);

        CreateScoreboard.o = o;
        return b;
    }

    public static void setScoreboard(Player p, String type, Boolean setscoreboard) {
        if (type.equals("Normal")) {
            if (setscoreboard.equals(false)) {
                Scoreboard b = p.getScoreboard();

                b.getTeam("playercount").setPrefix(ChatColor.translateAlternateColorCodes('&', "&c" + Bukkit.getOnlinePlayers().size() + "&7/50"));
                o.getScore(ChatColor.RED + "" + ChatColor.GRAY).setScore(1);
            } else if (setscoreboard.equals(true)) {
                p.setScoreboard(new CreateScoreboard().normal());
            }
        }
    }
}
