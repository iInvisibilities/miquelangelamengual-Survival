package es.hulk.survival.listeners;

import es.hulk.survival.utils.UUIDs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandsListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getPlayer().getUniqueId().equals(UUIDs.rafaUUID())) {
            if (event.getMessage().startsWith("/time set")) {
                event.getPlayer().sendMessage("Nono");
                event.setCancelled(true);
            }
        }
    }

}
