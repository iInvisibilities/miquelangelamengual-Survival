package es.hulk.survival.managers;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public class Warp {

    private final String name;
    private final Location location;

    public Warp(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public Location getLocation() {
        return location;
    }


}
