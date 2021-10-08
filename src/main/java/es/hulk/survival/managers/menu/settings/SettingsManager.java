package es.hulk.survival.managers.menu.settings;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SettingsManager {

    private final FileConfig menuConfig = Survival.get().getMenuConfig();
    private final List<Settings> items = new ArrayList<>();

    public void load() {
        items.clear();
        ConfigurationSection section = menuConfig.getConfiguration().getConfigurationSection("SETTINGS_MENU.ITEMS");

        assert section != null;
        for (String item : section.getKeys(false)) {
            String displayName = menuConfig.getString("SETTINGS_MENU.ITEMS." + item + ".DISPLAYNAME");
            List<String> description = menuConfig.getStringList("SETTINGS_MENU.ITEMS." + item + ".LORE");
            Material material = Material.valueOf(menuConfig.getString("SETTINGS_MENU.ITEMS." + item + ".MATERIAL"));
            int data = menuConfig.getInt("SETTINGS_MENU.ITEMS." + item + ".DATA");
            int slot = menuConfig.getInt("SETTINGS_MENU.ITEMS." + item + ".SLOT");
            String action = menuConfig.getString("SETTINGS_MENU.ITEMS." + item + ".ACTION");

            items.add(new Settings(displayName, description, material, data,slot , action));
        }
    }

}
