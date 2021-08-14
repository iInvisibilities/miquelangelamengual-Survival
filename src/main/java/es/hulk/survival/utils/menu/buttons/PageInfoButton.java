package es.hulk.survival.utils.menu.buttons;

import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.menu.Button;
import es.hulk.survival.utils.menu.pagination.PaginatedMenu;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

public class PageInfoButton extends Button
{
    private final PaginatedMenu paginatedMenu;

    @Override
    public ItemStack getButtonItem(final Player player) {
        return new ItemBuilder(Material.NETHER_STAR).name("&ePage Info").lore("&e" + this.paginatedMenu.getPage() + "&7/&a" + this.paginatedMenu.getPages(player)).build();
    }

    @Override
    public boolean shouldCancel(final Player player, final int slot, final ClickType clickType) {
        return true;
    }

    public PageInfoButton(final PaginatedMenu paginatedMenu) {
        this.paginatedMenu = paginatedMenu;
    }
}
