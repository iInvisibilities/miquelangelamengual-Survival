package es.hulk.survival.providers;

import dev.risas.panda.files.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import io.github.nosequel.tab.shared.entry.TabElement;
import io.github.nosequel.tab.shared.entry.TabElementHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TablistProvider implements TabElementHandler {

    @Override
    public TabElement getElement(Player player) {
        final TabElement element = new TabElement();

        List<String> test = Arrays.asList("LEFT", "MIDDLE", "RIGHT", "FAR-RIGHT");

        for (int j = 0; j < 4; j++) {
            String lado = test.get(j);
            for (int i = 0; i < 20; i++) {
                element.add(j, i, PlaceholderAPI.setPlaceholders(player, Survival.get().getTabConfig().getString("TABLIST." + lado + "." + (i + 1))));
            }
        }

        element.setFooter(Utils.color(PlaceholderAPI.setPlaceholders(player, Survival.get().getTabConfig().getString("TABLIST.FOOTER"))));
        element.setHeader(Utils.color(PlaceholderAPI.setPlaceholders(player, Survival.get().getTabConfig().getString("TABLIST.HEADER"))));

        return element;
    }
}