package es.hulk.survival.utils;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class LocationUtils {

    public static String playerLocation(Player player) {
        Location location = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
        return String.valueOf(location);
    }

    public static String offlinePlayerLocation(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        Location location = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
        return String.valueOf(location);
    }

}
