package es.hulk.survival.utils.menu.buttons;

import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.menu.Button;
import es.hulk.survival.utils.menu.Menu;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

public class BackButton extends Button
{
    private final Menu back;

    @Override
    public ItemStack getButtonItem(final Player player) {
        return new ItemBuilder(Material.RED_BED).name("&cGo back").build();
    }

    @Override
    public void clicked(final Player player, final int i, final ClickType clickType, final int hb) {
        Button.playNeutral(player);
        this.back.openMenu(player);
    }

    public BackButton(final Menu back) {
        this.back = back;
    }
}
