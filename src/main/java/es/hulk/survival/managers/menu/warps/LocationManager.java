package es.hulk.survival.managers.menu.warps;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.Warp;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.FileConfig;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class LocationManager {

    private final FileConfig menuConfig = Survival.get().getMenuConfig();
    private final List<Location> locations = new ArrayList<>();

    public void load() {
        locations.clear();

        ConfigurationSection section = menuConfig.getConfiguration().getConfigurationSection("LOCATION_MENU.WARPS");

        for (String item : section.getKeys(false)) {
            String name = menuConfig.getString("LOCATION_MENU.WARPS." + item + ".NAME");
            String world = menuConfig.getString("LOCATION_MENU.WARPS." + item + ".WORLD");
            double x = menuConfig.getDouble("LOCATION_MENU.WARPS." + item + ".X");
            double y = menuConfig.getDouble("LOCATION_MENU.WARPS." + item + ".Y");
            double z = menuConfig.getDouble("LOCATION_MENU.WARPS." + item + ".Z");
            double yaw = menuConfig.getDouble("LOCATION_MENU.WARPS." + item + ".YAW");
            double pitch = menuConfig.getDouble("LOCATION_MENU.WARPS." + item + ".PITCH");

            locations.add(new Location(name, world, x, y, z, yaw, pitch));
        }
    }

}
