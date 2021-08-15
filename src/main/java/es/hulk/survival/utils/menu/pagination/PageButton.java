package es.hulk.survival.utils.menu.pagination;

import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class PageButton extends Button
{
    private final int mod;
    private final PaginatedMenu menu;

    @Override
    public ItemStack getButtonItem(final Player player) {
        ItemBuilder itemBuilder = new ItemBuilder(Material.WHITE_CARPET);
        if (this.mod > 0) {
            itemBuilder.data((short)13);
        }
        else {
            itemBuilder.data((short)14);
        }
        if (this.hasNext(player)) {
            itemBuilder.name((this.mod > 0) ? "&aNext page" : "&cPrevious page");
        }
        else {
            itemBuilder.name("&7" + ((this.mod > 0) ? "Last page" : "First page"));
        }
        return itemBuilder.build();
    }

    @Override
    public void clicked(final Player player, final int i, final ClickType clickType, final int hb) {
        if (this.hasNext(player)) {
            this.menu.modPage(player, this.mod);
            Button.playNeutral(player);
        }
        else {
            Button.playFail(player);
        }
    }

    private boolean hasNext(final Player player) {
        final int pg = this.menu.getPage() + this.mod;
        return pg > 0 && this.menu.getPages(player) >= pg;
    }

    public PageButton(final int mod, final PaginatedMenu menu) {
        this.mod = mod;
        this.menu = menu;
    }
}
