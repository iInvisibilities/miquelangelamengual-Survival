package es.hulk.survival.managers.menu.warps.menu;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.menu.Button;
import es.hulk.survival.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.Map;

public class LocationMenu extends Menu {

    private final FileConfig menuConfig = Survival.get().getMenuConfig();

    @Override
    public String getTitle(Player player) {
        return null;
    }

    @Override
    public int getSize() {
        return menuConfig.getInt("LOCATIONS_MENU.SIZE");
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        return null;
    }
}
