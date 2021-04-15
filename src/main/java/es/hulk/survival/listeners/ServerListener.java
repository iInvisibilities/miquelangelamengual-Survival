package es.hulk.survival.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListener implements Listener {

    @EventHandler
    public void ServerList(ServerListPingEvent event) {
        if (event.getMaxPlayers() != 80) {
            event.setMaxPlayers(100);
        }
    }

}
