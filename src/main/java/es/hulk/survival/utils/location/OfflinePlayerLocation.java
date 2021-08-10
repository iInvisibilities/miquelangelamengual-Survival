package es.hulk.survival.utils.location;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class OfflinePlayerLocation {

    public static String getWorld(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        switch (player.getWorld().getName()) {
            case "world":
                return "Overworld";
            case "world_nether":
                return "Nether";
            case "world_the_end":
                return "The End";
            default:
                return "No World Found";
        }
    }

    public static int coordinateX(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        return (int) player.getLocation().getX();
    }

    public static int coordinateY(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        return (int) player.getLocation().getY();
    }

    public static int coordinateZ(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        return (int) player.getLocation().getZ();
    }

}
