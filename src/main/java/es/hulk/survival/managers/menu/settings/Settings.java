package es.hulk.survival.managers.menu.settings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;

import java.util.List;

@AllArgsConstructor
@Getter
public class Settings {

    private String displayName;
    private List<String> description;
    private Material material;
    private int data;
    private int slot;

}
