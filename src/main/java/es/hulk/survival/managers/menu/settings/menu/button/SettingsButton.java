package es.hulk.survival.managers.menu.settings.menu.button;

import es.hulk.survival.managers.menu.settings.SettingsMenu;
import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.menu.Button;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class SettingsButton extends Button {

    private final SettingsMenu settings;

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

    }
}
