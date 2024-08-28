package ru.lxckscream.lsadminzone.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import ru.lxckscream.lsadminzone.Main;
import ru.lxckscream.lsadminzone.command.AdminZoneCommand;

import java.util.ArrayList;
import java.util.HashMap;

import static ru.lxckscream.lsadminzone.utils.Hex.color;

public class AdminZoneManager {
    private HashMap<Player, Location> adminsInZone = new HashMap<>();
    private Location location;

    public AdminZoneManager() {
        String[] split = Main.getInstance().getConfig().getString("az-location").split("; ");
        this.location = new Location(Bukkit.getWorld(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
    }

    public void join(Player player) {
        if (adminsInZone.get(player) == null) {
            adminsInZone.put(player, player.getLocation());
            player.teleport(location);
            player.sendMessage(color("&6ls-AdminZone &7» &aВы телепортировались на админ зону."));
        } else {
            player.sendMessage(color("&6ls-AdminZone &7» &cВы уже на админ зоне."));
        }
    }

    public void leave(Player player) {
        if (adminsInZone.get(player) != null) {
            Location location1 = adminsInZone.get(player);
            player.teleport(location1);
            adminsInZone.remove(player);
            player.sendMessage(color("&6ls-AdminZone &7» &aВы ушли с админ зоны."));
        } else {
            player.sendMessage(color("&6ls-AdminZone &7» &cВы не на админ зоне."));
        }
    }

    public HashMap<Player, Location> getAdminsInZone() {
        return adminsInZone;
    }

    public void setAdminsInZone(HashMap<Player, Location> adminsInZone) {
        this.adminsInZone = adminsInZone;
    }
}
