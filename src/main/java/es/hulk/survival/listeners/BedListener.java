package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.Plugin;

public class BedListener implements Listener {

    private Survival main;

    @EventHandler
    public void onPlayerJoinBedEvent(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        Bukkit.getServer().getScheduler().runTaskLater((Plugin)this.main, (Runnable)new Runnable() {
            @Override
            public void run() {
                if (player.isSleeping()) {
                    player.getWorld().setTime(0L);
                    player.getWorld().setStorm(false);
                    player.getWorld().setThundering(false);
                }
            }
        }, 100L);
    }

}
