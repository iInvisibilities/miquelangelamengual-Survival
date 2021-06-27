package es.hulk.survival.listeners;

import es.hulk.survival.utils.CC;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
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
                event.setFormat(Utils.color(PlaceholderAPI.setPlaceholders(player, mainConfig.getString("CHAT.FORMAT")
                        .replaceAll("%player%", player.getDisplayName())
                        .replace("%message%", "%2$s"))));
        }
    }

}
