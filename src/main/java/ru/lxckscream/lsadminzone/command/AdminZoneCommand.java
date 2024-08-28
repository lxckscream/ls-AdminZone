package ru.lxckscream.lsadminzone.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.lxckscream.lsadminzone.Main;

import static ru.lxckscream.lsadminzone.utils.Hex.color;

public class AdminZoneCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage(color("&6ls-AdminZone &7» &6/adminzone (join/leave)"));
        } else if (strings.length == 1) {
            if (commandSender.hasPermission("lsadminzone.use")) {
                if (strings[0].equalsIgnoreCase("join")) {
                    Main.getAdminZoneManager().join((Player) commandSender);
                } else if (strings[0].equalsIgnoreCase("leave")) {
                    Main.getAdminZoneManager().leave((Player) commandSender);
                } else {
                    commandSender.sendMessage(color("&6ls-AdminZone &7» &6/adminzone (join/leave)"));
                }
            } else {
                commandSender.sendMessage(color("&6ls-AdminZone &7» &cНет прав."));
            }
        } else {
            commandSender.sendMessage(color("&6ls-AdminZone &7» &cСлишком много аргументов"));
        }
        return true;
    }
}
