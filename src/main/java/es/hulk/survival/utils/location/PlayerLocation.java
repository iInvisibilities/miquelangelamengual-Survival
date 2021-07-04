package es.hulk.survival.utils.location;

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

    public static int coordinateX(Player player) {
        return (int) player.getLocation().getX();
    }

    public static int coordinateY(Player player) {
        return (int) player.getLocation().getY();
    }

    public static int coordinateZ(Player player) {
        return (int) player.getLocation().getZ();
    }


}
