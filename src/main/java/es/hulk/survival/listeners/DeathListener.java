package es.hulk.survival.listeners;

import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.location.OfflinePlayerLocation;
import es.hulk.tablist.utils.CC;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Hulk
 * at 05/03/2022 13:41
 * Project: Survival
 * Class: DeathListener
 */

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        assert player != null;
        player.sendTitle(Utils.color("&4&lHAS MUERTO"), "", 10, 100, 10);
        player.sendMessage(Utils.color("&aCoordenadas donde has muerto&7: "));
        player.sendMessage(Utils.color("&bMundo&7: &a" + PlayerUtils.getWorld(player)));
        player.sendMessage(Utils.color("&bX&7: &a" + String.valueOf(OfflinePlayerLocation.coordinateX(player))));
        player.sendMessage(Utils.color("&bY&7: &a" + String.valueOf(OfflinePlayerLocation.coordinateY(player))));
        player.sendMessage(Utils.color("&bZ&7: &a" + String.valueOf(OfflinePlayerLocation.coordinateZ(player))));
    }
}
