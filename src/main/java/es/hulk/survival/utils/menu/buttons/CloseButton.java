package es.hulk.survival.utils.menu.buttons;

import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class CloseButton extends Button
{
    @Override
    public ItemStack getButtonItem(final Player player) {
        return new ItemBuilder(Material.INK_SAC).data((short)1).name("&cClose").build();
    }

    @Override
    public void clicked(final Player player, final int i, final ClickType clickType, final int hb) {
        Button.playNeutral(player);
        player.closeInventory();
    }
}