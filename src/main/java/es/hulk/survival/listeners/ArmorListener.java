package es.hulk.survival.listeners;

import es.hulk.survival.listeners.events.ArmorEquipEvent;
import es.hulk.survival.listeners.events.ArmorUnEquipEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class ArmorListener implements Listener {

    @EventHandler
    public void onEquip(ArmorEquipEvent event) {
        Player player = event.getPlayer();
        ItemStack[] armor2 = event.getArmor();
        for (final ItemStack armor : armor2) {
            if (armor.hasItemMeta() && armor.getItemMeta().hasLore()) {
                if (armor.getItemMeta().getLore().equals("Fly")) {
                    if (player.getAllowFlight()) {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onUnEquip(ArmorUnEquipEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
            if (item.getItemMeta().getLore().equals("Fly")) {
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                }
            }
        }
    }
}
