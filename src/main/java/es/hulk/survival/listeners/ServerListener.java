package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListener implements Listener {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @EventHandler
    public void ServerList(ServerListPingEvent event) {
        if (event.getMaxPlayers() != 80) {
            event.setMaxPlayers(100);
        }
        event.setMaxPlayers(mainConfig.getInt("SET-SLOTS"));
    }

}
