package es.hulk.survival.managers.warp;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class WarpManager {

    private final Map<String, Warp> warps = new HashMap<>();
    private ArrayList<String> names = new ArrayList<>();
    private final Survival plugin;

    public void saveNames() {
        FileConfig config = Survival.get().getLocationsConfig();
        String aux = names.toString().replace("[", "").replace("]", "");
        config.getConfiguration().set("WARPNAME", aux);
    }

    public WarpManager(Survival plugin) {
        this.plugin = plugin;
    }

    public Warp getWarpByName(String name) {
        return this.warps.get(name);
    }

    public List<String> getWarpListByName() {
        return new ArrayList<>(this.warps.keySet());
    }

    public void createWarp(String warpName, Location location) {
        this.warps.put(warpName, new Warp(warpName, location));
        names.add(warpName);
    }

    public void deleteWarpByName(String warpName) {
        this.warps.remove(warpName);
        names.remove(warpName);
    }

    public void clearWarp() {
        this.warps.clear();
        names.clear();
    }


    public void serializeLocation(Warp warp) {
        FileConfig config = Survival.get().getLocationsConfig();
        Location location = warp.getLocation().clone();

        String world = location.getWorld().getName();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        double yaw = location.getYaw();
        double pitch = location.getPitch();

        config.getConfiguration().set("WARPS." + warp.getName() + ".WORLD", world);
        config.getConfiguration().set("WARPS." + warp.getName() + ".X", x);
        config.getConfiguration().set("WARPS." + warp.getName() + ".Y", y);
        config.getConfiguration().set("WARPS." + warp.getName() + ".Z", z);
        config.getConfiguration().set("WARPS." + warp.getName() + ".YAW", yaw);
        config.getConfiguration().set("WARPS." + warp.getName() + ".PITCH", pitch);

        config.save();
    }

    public void saveWarps() {
        for (String warpName : this.warps.keySet()) {
            this.serializeLocation(this.warps.get(warpName));
        }
    }

    public void loadWarps() {
        FileConfig config = Survival.get().getLocationsConfig();
        if(!config.getConfiguration().isConfigurationSection("WARPS")) return;

        for(String warpName : config.getConfiguration().getConfigurationSection("WARPS").getKeys(false)){

            World world = Bukkit.getWorld(config.getString("WARPS." + warpName + ".WORLD"));
            double x = config.getDouble("WARPS." + warpName + ".X");
            double y = config.getDouble("WARPS." + warpName + ".Y");
            double z = config.getDouble("WARPS." + warpName + ".Z");
            float yaw = (float) config.getDouble("WARPS." + warpName + ".YAW");
            float pitch = (float) config.getDouble("WARPS." + warpName + ".PITCH");

            Location location = new Location(world, x, y, z, yaw, pitch);
            this.warps.put(warpName, new Warp(warpName, location));
            names.add(warpName);
        }
        config.getConfiguration().set("WARPS", null);
        config.save();
    }
}
