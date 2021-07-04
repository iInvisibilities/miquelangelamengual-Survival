package es.hulk.survival.utils.location;

import org.bukkit.entity.Player;

public class BedLocation {

    public static int bedCoordinateX(Player player) {
        return (int) player.getBedSpawnLocation().getX();
    }

    public static int bedCoordinateY(Player player) {
        return (int) player.getBedSpawnLocation().getY();
    }

    public static int bedCoordinateZ(Player player) {
        return (int) player.getBedSpawnLocation().getZ();
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
