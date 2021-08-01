package es.hulk.survival.listeners.events;

import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class ArmorEquipEvent extends Event implements Cancellable
{
    private static final HandlerList handlers;
    private final Player player;
    private final ItemStack[] armor;
    private boolean isCancelled;

    public ArmorEquipEvent(final Player player, final ItemStack[] armor) {
        this.player = player;
        this.armor = armor;
        this.isCancelled = false;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(final boolean b) {
        this.isCancelled = b;
    }

    public HandlerList getHandlers() {
        return ArmorEquipEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return ArmorEquipEvent.handlers;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ItemStack[] getArmor() {
        return this.armor;
    }

    static {
        handlers = new HandlerList();
    }
}

