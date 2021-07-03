package rygb.tech.queueserver.mccore.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import rygb.tech.queueserver.mccore.functions.CreateScoreboard;

public class JoinLeaveEvent implements Listener {
    public static Integer playersinqueue = 0;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String player = event.getPlayer().getDisplayName();

        playersinqueue++;
        p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&4&lIN QUEUE"), ChatColor.translateAlternateColorCodes('&', "&fYou'll be sent to &chub &fshortly"), 5, 24000, 5);
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BASS, 100, 1);
        p.setGameMode(GameMode.ADVENTURE);

        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&4&l> &c" + player + " &fjoined the queue. Their position is &c#" + playersinqueue));

        //setup the scoreboard for the player
        CreateScoreboard.setScoreboard(p, "Normal", true);

        //create scoreboard for all players
        for (Player loopplayer: Bukkit.getOnlinePlayers()) {
            CreateScoreboard.setScoreboard(loopplayer, "Normal", false);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        String player = event.getPlayer().getDisplayName();

        //create scoreboard for all players
        for (Player loopplayer : Bukkit.getOnlinePlayers()) {
            CreateScoreboard.setScoreboard(loopplayer, "Normal", false);
        }

        playersinqueue--;
        String s = ChatColor.translateAlternateColorCodes('&', "&4&l> &c" + player + " &fleft the queue.");
        event.setQuitMessage(s);
    }
}
