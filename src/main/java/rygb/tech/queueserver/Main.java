package rygb.tech.queueserver;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        //Register events
        Register.registerEvents();

        Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);

        //set queue
        int queue = 0;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }
}
