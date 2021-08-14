package es.hulk.survival.utils.menu.buttons;

import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.menu.Button;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

public class AirButton extends Button
{
    @Override
    public ItemStack getButtonItem(final Player player) {
        return new ItemBuilder(Material.AIR).build();
    }

    @Override
    public boolean shouldCancel(final Player player, final int slot, final ClickType clickType) {
        return true;
    }
}