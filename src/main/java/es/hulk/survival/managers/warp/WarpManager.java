package es.hulk.survival.managers.warp;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarpManager {

    private FileConfig locationsConfig = Survival.get().getLocationsConfig();
    private final Map<String, Warp> warps = new HashMap<>();
    private final Survival plugin;

    public WarpManager(Survival plugin) {
        this.plugin = plugin;
    }

    @Nullable
    public Warp getWarpByName(String name) {
        return this.warps.get(name);
    }

    public List<String> getWarpListByName() {
        return new ArrayList<>(this.warps.keySet());
    }

    public void createWarp(String warpName, Location location) {
        this.warps.put(warpName, new Warp(warpName, location));
    }

    public void deleteWarpByName(String warpName) {
        this.warps.remove(warpName);
    }

    public void clearWarp() {
        this.warps.clear();
    }

    public void serializeLocation(Warp warp) {
        Location location = warp.getLocation().clone();

        String world = location.getWorld().getName();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        double yaw = location.getYaw();
        double pitch = location.getPitch();

        locationsConfig.getConfiguration().set("warps." + warp.getName() + ".world", world);
        locationsConfig.getConfiguration().set("warps." + warp.getName() + ".x", x);
        locationsConfig.getConfiguration().set("warps." + warp.getName() + ".y", y);
        locationsConfig.getConfiguration().set("warps." + warp.getName() + ".z", z);
        locationsConfig.getConfiguration().set("warps." + warp.getName() + ".yaw", yaw);
        locationsConfig.getConfiguration().set("warps." + warp.getName() + ".pitch", pitch);

        plugin.saveConfig();
    }

    public void saveWarps() {
        for (String warpName : this.warps.keySet()) {
            this.serializeLocation(this.warps.get(warpName));
        }
    }

    public void loadWarps() {
        FileConfiguration config = plugin.getConfig();
        if (!config.isConfigurationSection("warps")) return;

        for (String warpName : config.getConfigurationSection("warps").getKeys(false)) {

            World world = Bukkit.getWorld(config.getString("warps." + warpName + ".world"));
            double x = config.getDouble("warps." + warpName + ".x");
            double y = config.getDouble("warps." + warpName + ".y");
            double z = config.getDouble("warps." + warpName + ".z");
            float yaw = (float) config.getDouble("warps." + warpName + ".yaw");
            float pitch = (float) config.getDouble("warps." + warpName + ".pitch");

            Location location = new Location(world, x, y, z, yaw, pitch);

            this.warps.put(warpName, new Warp(warpName, location));

        }
        config.set("warps", null);
        plugin.saveConfig();
    }
}
