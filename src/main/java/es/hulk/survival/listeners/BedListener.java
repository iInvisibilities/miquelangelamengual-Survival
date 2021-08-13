package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BedListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();
    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();

    @EventHandler
    public void onPlayerJoinBedEvent(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();

        if (Bukkit.getWorlds().get(0).getTime() >= 12500 || Bukkit.getWorlds().get(0).hasStorm()) {
            if (!mainConfig.getBoolean("BED-INSTANT-SLEEP")) {
                Bukkit.broadcastMessage(Utils.color(messagesConfig.getString("BED_LISTENER.MESSAGE").replaceAll("<player>", player.getDisplayName())));
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (player.isSleeping()) {
                            player.getWorld().setTime(0L);
                            player.getWorld().setStorm(false);
                            player.getWorld().setThundering(false);
                        }
                    }
                }.runTaskLater(Survival.get(), 100L);
            } else if (player.isSleeping()) {
                player.getWorld().setTime(0L);
                player.getWorld().setStorm(false);
                player.getWorld().setThundering(false);
            }
        } else {
            player.sendMessage(Utils.color(messagesConfig.getString("BED_LISTENER.ERROR")));
        }
    }
}
