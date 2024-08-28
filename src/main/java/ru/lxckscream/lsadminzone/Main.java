package ru.lxckscream.lsadminzone;

import org.bukkit.plugin.java.JavaPlugin;
import ru.lxckscream.lsadminzone.command.AdminZoneCommand;
import ru.lxckscream.lsadminzone.managers.AdminZoneManager;

public final class Main extends JavaPlugin {
    static Main instance;
    static AdminZoneManager adminZoneManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        adminZoneManager = new AdminZoneManager();
        getCommand("adminzone").setExecutor(new AdminZoneCommand());

    }

    public static Main getInstance() {
        return instance;
    }

    public static AdminZoneManager getAdminZoneManager() {
        return adminZoneManager;
    }
}
