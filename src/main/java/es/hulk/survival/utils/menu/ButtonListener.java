package es.hulk.survival.utils.menu;

import org.bukkit.plugin.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;

public class ButtonListener implements Listener
{
    public ButtonListener(final Plugin plugin) {
        Bukkit.getPluginManager().registerEvents((Listener)this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onButtonPress(final InventoryClickEvent event) {
        final Player player = (Player)event.getWhoClicked();
        final Menu openMenu = Menu.currentlyOpenedMenus.get(player.getName());
        if (openMenu != null) {
            if (event.getSlot() != event.getRawSlot()) {
                if (event.getClick() == ClickType.SHIFT_LEFT || event.getClick() == ClickType.SHIFT_RIGHT) {
                    event.setCancelled(false);
                }
                return;
            }
            if (openMenu.getButtons().containsKey(event.getSlot())) {
                final Button button = openMenu.getButtons().get(event.getSlot());
                final boolean shouldCancel = button.shouldCancel(player, event.getSlot(), event.getClick());
                final boolean shouldShift = button.shouldShift(player, event.getSlot(), event.getClick());
                if (shouldCancel && shouldShift) {
                    event.setCancelled(true);
                }
                else {
                    event.setCancelled(shouldCancel);
                }
                button.clicked(player, event.getSlot(), event.getClick(), event.getHotbarButton());
                if (Menu.currentlyOpenedMenus.containsKey(player.getName())) {
                    final Menu newMenu = Menu.currentlyOpenedMenus.get(player.getName());
                    if (newMenu == openMenu && openMenu.isUpdateAfterClick()) {
                        openMenu.setClosedByMenu(true);
                        newMenu.openMenu(player);
                    }
                }
                else if (button.shouldUpdate(player, event.getSlot(), event.getClick())) {
                    openMenu.setClosedByMenu(true);
                    openMenu.openMenu(player);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClose(final InventoryCloseEvent event) {
        final Player player = (Player)event.getPlayer();
        final Menu openMenu = Menu.currentlyOpenedMenus.get(player.getName());
        if (openMenu != null) {
            openMenu.onClose(player);
            Menu.currentlyOpenedMenus.remove(player.getName());
        }
    }
}