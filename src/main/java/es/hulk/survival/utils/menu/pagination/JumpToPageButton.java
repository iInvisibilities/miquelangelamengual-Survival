package es.hulk.survival.utils.menu.pagination;

import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.menu.Button;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

public class JumpToPageButton extends Button
{
    private final int page;
    private final PaginatedMenu menu;
    private final boolean current;

    @Override
    public ItemStack getButtonItem(final Player player) {
        ItemBuilder itemBuilder = new ItemBuilder(this.current ? Material.ENCHANTED_BOOK : Material.BOOK).amount(this.page);
        itemBuilder.name(Utils.color("&cPage " + this.page));
        if (this.current) {
            itemBuilder.lore("", Utils.color("&aCurrent page"));
        }
        return itemBuilder.build();
    }

    @Override
    public void clicked(final Player player, final int i, final ClickType clickType, final int hb) {
        this.menu.modPage(player, this.page - this.menu.getPage());
        Button.playNeutral(player);
    }

    public JumpToPageButton(final int page, final PaginatedMenu menu, final boolean current) {
        this.page = page;
        this.menu = menu;
        this.current = current;
    }
}