package es.hulk.survival.utils.Location;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Objects;

public class LocationUtils {

    public static String playerLocation(Player player) {
        org.bukkit.Location location = new org.bukkit.Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
        return String.valueOf(location);
    }

    public static String offlinePlayerLocation(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        assert player != null;
        org.bukkit.Location location = new org.bukkit.Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
        return String.valueOf(location);
    }

    public static String getWorld(Player player) {
        return Objects.requireNonNull(player.getLocation().getWorld()).getName();
    }

}
