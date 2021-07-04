package es.hulk.survival.utils.location;

import org.bukkit.entity.Player;

public class BedLocation {

    public static String bedCoordinateX(Player player) {
        return String.valueOf(player.getBedSpawnLocation().getX());
    }

    public static String bedCoordinateY(Player player) {
        return String.valueOf(player.getBedSpawnLocation().getY());
    }

    public static String bedCoordinateZ(Player player) {
        return String.valueOf(player.getBedSpawnLocation().getZ());
    }

    public static String getBedWorld(Player player) {
        switch (LocationUtils.getWorld(player)) {
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

}
