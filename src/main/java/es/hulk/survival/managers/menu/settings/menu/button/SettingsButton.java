package es.hulk.survival.managers.menu.settings.menu.button;

import es.hulk.survival.managers.menu.settings.Settings;
import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.menu.Button;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class SettingsButton extends Button {

    private final Settings settings;

    @Override
    public ItemStack getButtonItem(Player p0) {

        return new ItemBuilder(settings.getMaterial())
                .data(settings.getData())
                .name(settings.getDisplayName())
                .lore(settings.getDescription())
                .build();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

        if (settings.getAction().equals("TOGGLEFLY")) {
            player.performCommand("fly");
            return;
        }

        if (settings.getAction().equals("TP_TO_BED")) {
            player.performCommand("tptobed");
            return;
        }

        if (settings.getAction().equals("SEED_COMMAND")) {
            player.performCommand("semilla");
            return;
        }

        if (settings.getAction().equals("PLAYIME_COMMAND")) {
            player.performCommand("playtime");
            return;
        }

        if (settings.getAction().equals("COORDS_COMMAND")) {
            player.performCommand("coords");
            return;
        }

        if (settings.getAction().equals("BEDCOORDS_COMMAND")) {
            player.performCommand("camacoords");
            return;
        }

        if (settings.getAction().equals("OPEN_ENDERCHEST")) {
            player.openInventory(player.getEnderChest());
            return;
        }

        if (settings.getAction().equals("SUICIDE_COMMAND")) {
            player.performCommand("suicide");
            return;
        }

        if (settings.getAction().equals("PING_COMMAND")) {
            player.performCommand("ping");
            return;
        }

        if (settings.getAction().equals("DISCORD_COMMAND")) {
            player.performCommand("discord");
            return;
        }

        if (settings.getAction().equals("SPAWN_COMMAND")) {
            player.performCommand("spawn");
            return;
        }

        if (settings.getAction().equals("HELP_COMMAND")) {
            player.performCommand("help");
            return;
        }
    }
}
