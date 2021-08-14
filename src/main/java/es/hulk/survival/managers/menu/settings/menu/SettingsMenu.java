package es.hulk.survival.managers.menu.settings.menu;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.menu.settings.Settings;
import es.hulk.survival.managers.menu.settings.menu.button.SettingsButton;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.menu.Button;
import es.hulk.survival.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class SettingsMenu extends Menu {

    private final FileConfig menuConfig = Survival.get().getMenuConfig();

    @Override
    public String getTitle(Player player) {
        return menuConfig.getString("SETTINGS_MENU.DISPLAYNAME");
    }

    @Override
    public int getSize() {
        return menuConfig.getInt("SETTINGS_MENU.SIZE");
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        final Map<Integer, Button> buttons = new HashMap<>();

        for (Settings settings : Survival.get().getSettingsManager().getItems()) {
            buttons.put(settings.getSlot(), new SettingsButton(settings));
        }

        return buttons;
    }
}
