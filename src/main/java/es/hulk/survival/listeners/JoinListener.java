package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(Utils.color(PlaceholderAPI.setPlaceholders(player, mainConfig.getString("PLAYER-JOIN-MESSAGE").replaceAll("%player%", player.getDisplayName()))));

        if (mainConfig.getBoolean("JOIN-MESSAGE.ENABLE")) {
            mainConfig.getStringList("JOIN-MESSAGE.LINES").forEach(lines -> {
                lines = Utils.color(PlaceholderAPI.setPlaceholders(player, lines));
                player.sendMessage(lines);
            });
        }

        if (!player.hasPlayedBefore()) {
            player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 20));
        }
    }

}
