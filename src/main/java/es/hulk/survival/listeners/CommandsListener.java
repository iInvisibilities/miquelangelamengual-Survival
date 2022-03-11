package es.hulk.survival.listeners;

import es.hulk.survival.utils.PlayerUUID;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandsListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getPlayer().getUniqueId().equals(PlayerUUID.RAFA)) {
            if (event.getMessage().startsWith("/time set")) {
                event.getPlayer().sendMessage("Nono");
                event.setCancelled(true);
            }
        }
    }

}
