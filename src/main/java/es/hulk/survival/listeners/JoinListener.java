package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();
    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(Utils.color(messagesConfig.getString("BROADCAST.JOIN").replaceAll("<player>", player.getDisplayName())));

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
