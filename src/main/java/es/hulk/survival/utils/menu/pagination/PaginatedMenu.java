package es.hulk.survival.utils.menu.pagination;

import es.hulk.survival.utils.menu.Button;
import es.hulk.survival.utils.menu.Menu;
import org.bukkit.entity.*;
import java.util.*;

public abstract class PaginatedMenu extends Menu
{
    private int page;

    public PaginatedMenu() {
        this.page = 1;
        this.setUpdateAfterClick(false);
    }

    @Override
    public String getTitle(final Player player) {
        return String.valueOf(this.getPrePaginatedTitle(player)) + " - " + this.page + "/" + this.getPages(player);
    }

    public final void modPage(final Player player, final int mod) {
        this.page += mod;
        this.getButtons().clear();
        this.openMenu(player);
    }

    public final int getPages(final Player player) {
        final int buttonAmount = this.getAllPagesButtons(player).size();
        if (buttonAmount == 0) {
            return 1;
        }
        return (int)Math.ceil(buttonAmount / (double)this.getMaxItemsPerPage(player));
    }

    @Override
    public final Map<Integer, Button> getButtons(final Player player) {
        final int minIndex = (int)((this.page - 1) * (double)this.getMaxItemsPerPage(player));
        final int maxIndex = (int)(this.page * (double)this.getMaxItemsPerPage(player));
        final HashMap<Integer, Button> buttons = new HashMap<Integer, Button>();
        for (final Map.Entry<Integer, Button> entry : this.getAllPagesButtons(player).entrySet()) {
            int ind = entry.getKey();
            if (ind >= minIndex && ind < maxIndex) {
                ind -= (int)(this.getMaxItemsPerPage(player) * (double)(this.page - 1));
                buttons.put(ind, entry.getValue());
            }
        }
        final Map<Integer, Button> global = this.getGlobalButtons(player);
        if (global != null) {
            for (final Map.Entry<Integer, Button> gent : global.entrySet()) {
                buttons.put(gent.getKey(), gent.getValue());
            }
        }
        return buttons;
    }

    public int getMaxItemsPerPage(final Player player) {
        return 18;
    }

    public Map<Integer, Button> getGlobalButtons(final Player player) {
        return null;
    }

    public abstract String getPrePaginatedTitle(final Player p0);

    public abstract Map<Integer, Button> getAllPagesButtons(final Player p0);

    public int getPage() {
        return this.page;
    }
}