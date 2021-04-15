package es.hulk.survival.listeners;

import dev.risas.panda.files.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();

    @EventHandler
    public void QuitEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(Utils.color(PlaceholderAPI.setPlaceholders(player, mainConfig.getString("PLAYER-QUIT-MESSAGE").replaceAll("%player%", player.getDisplayName()))));
    }

}
