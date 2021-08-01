package es.hulk.survival.listeners;

import es.hulk.survival.listeners.events.ArmorEquipEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

public class ArmorListener {

    @EventHandler
    public void onEquip(ArmorEquipEvent event) {
        ItemStack chestplate = event.getArmor()[2];
    }

}
