package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import io.github.nosequel.tab.shared.entry.TabElement;
import io.github.nosequel.tab.shared.entry.TabElementHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class TablistProvider implements TabElementHandler {

    private final FileConfig tablistConfig = Survival.get().getTablistConfig();

    @Override
    public TabElement getElement(Player player) {
        final TabElement element = new TabElement();
        element.setHeader(Utils.color(PlaceholderAPI.setPlaceholders(player, tablistConfig.getString("TABLIST.HEADER"))));
        element.setFooter(Utils.color(PlaceholderAPI.setPlaceholders(player, tablistConfig.getString("TABLIST.FOOTER"))));

        return element;
    }
}