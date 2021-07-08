package es.hulk.survival.managers.warp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Setter
@Getter
@NotNull
public class Warp {

    private final String name;
    private final Location location;

}
