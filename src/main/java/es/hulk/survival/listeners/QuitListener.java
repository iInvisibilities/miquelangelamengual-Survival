package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (mainConfig.getBoolean("BOOLEANS.BROADCAST-QUIT")) {
            event.setQuitMessage(Utils.color(mainConfig.getString("BROADCAST.QUIT").replaceAll("<player>", player.getDisplayName())));
        } else {
            event.setQuitMessage(null);
        }
    }
}
