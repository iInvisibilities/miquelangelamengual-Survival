package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import io.github.nosequel.tab.shared.entry.TabElement;
import io.github.nosequel.tab.shared.entry.TabElementHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TablistProvider implements TabElementHandler {

    private final FileConfig tablistConfig = Survival.get().getTablistConfig();

    @Override
    public TabElement getElement(Player player) {
        final TabElement element = new TabElement();
        List<String> test = Arrays.asList("LEFT", "MIDDLE", "RIGHT", "FAR-RIGHT");

        for (int j = 0; j < 4; j++) {
            String corner = test.get(j);
            for (int i = 0; i < 20; i++) {
                element.add(j, i, PlaceholderAPI.setPlaceholders(player, tablistConfig.getString("TABLIST." + corner + "." + (i + 1))));
            }
        }
        return element;
    }
}
