package es.hulk.survival.listeners.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class ArmorUnEquipEvent extends Event implements Cancellable
{
    private static final HandlerList handlers;
    private final Player player;
    private final ItemStack item;
    private boolean isCancelled;

    public ArmorUnEquipEvent(final Player player, final ItemStack item) {
        this.player = player;
        this.item = item;
        this.isCancelled = false;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(final boolean b) {
        this.isCancelled = b;
    }

    public HandlerList getHandlers() {
        return ArmorUnEquipEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return ArmorUnEquipEvent.handlers;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ItemStack getItem() {
        return this.item;
    }

    static {
        handlers = new HandlerList();
    }
}

