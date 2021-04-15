package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import io.github.nosequel.tab.shared.entry.TabElement;
import io.github.nosequel.tab.shared.entry.TabElementHandler;
import org.bukkit.entity.Player;

public class TablistProvider implements TabElementHandler {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @Override
    public TabElement getElement(Player player) {
        final TabElement element = new TabElement();
        element.setHeader(Utils.color(mainConfig.getString("TABLIST.HEADER")));
        element.setHeader(Utils.color(mainConfig.getString("TABLIST.FOOTER")));
        return element;
    }
}
