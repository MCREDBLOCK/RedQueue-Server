package rygb.tech.queueserver;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import rygb.tech.queueserver.mccore.events.JoinLeaveEvent;

public class Register {
    private static Main pl = Main.getInstance();

    public static void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        // Register events
        pm.registerEvents(new JoinLeaveEvent(), pl);
        // pm.registerEvents(new Redblock6IsTrash(), pl);
    }
}
