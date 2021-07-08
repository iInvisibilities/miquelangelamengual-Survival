package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (mainConfig.getBoolean("BOOLEANS.BORADCAST-JOIN")) {
            event.setJoinMessage(Utils.color(PlaceholderAPI.setPlaceholders(player, mainConfig.getString("BROADCAST.JOIN").replaceAll("<player>", player.getDisplayName()))));
        } else {
            event.setJoinMessage(null);
        }

        if (mainConfig.getBoolean("JOIN-MESSAGE.ENABLE")) {
            for (String lines : mainConfig.getStringList("JOIN-MESSAGE.LINES")) {
                player.sendMessage(lines.replaceAll("<player>", player.getDisplayName()));
            }
        }

        if (!player.hasPlayedBefore()) {
            player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
            player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
            player.getInventory().addItem(new ItemStack(Material.STONE_AXE));
            player.getInventory().addItem(new ItemStack(Material.STONE_SHOVEL));
            player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 20));
        }
    }

}
