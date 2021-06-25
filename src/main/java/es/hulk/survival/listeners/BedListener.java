package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BedListener implements Listener {

    @EventHandler
    public void onPlayerJoinBedEvent(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
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
    }

}
