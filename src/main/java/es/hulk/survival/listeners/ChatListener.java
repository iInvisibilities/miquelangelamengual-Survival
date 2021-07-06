package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.rank.LuckPermsAPI;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (mainConfig.getBoolean("CHAT.ENABLED")) {
            event.setFormat(Utils.color(mainConfig.getString("CHAT.FORMAT")
                    .replaceAll("<rank-suffix>", LuckPermsAPI.getSuffix(player))
                    .replaceAll("<rank-prefix>", LuckPermsAPI.getPrefix(player))
                    .replaceAll("%player%", player.getDisplayName())
                    .replace("%message%", "%2$s")));
        }
    }
}
