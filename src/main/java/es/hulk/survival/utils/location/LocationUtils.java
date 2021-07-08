package es.hulk.survival.utils.location;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Objects;

public class LocationUtils {

    public static String getWorld(Player player) {
        return Objects.requireNonNull(player.getLocation().getWorld()).getName();
    }

}
