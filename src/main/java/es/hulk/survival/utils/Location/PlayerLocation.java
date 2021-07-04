package es.hulk.survival.utils.Location;

import org.bukkit.entity.Player;

public class PlayerLocation {

    public static String getWorld(Player player) {
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

    public static String coordinateX(Player player) {
        return String.valueOf(player.getLocation().getX());
    }

    public static String coordinateY(Player player) {
        return String.valueOf(player.getLocation().getY());
    }

    public static String coordinateZ(Player player) {
        return String.valueOf(player.getLocation().getZ());
    }

}
