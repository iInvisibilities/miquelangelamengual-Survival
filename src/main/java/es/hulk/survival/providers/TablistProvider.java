package es.hulk.survival.providers;

import dev.hely.tab.api.TabColumn;
import dev.hely.tab.api.TabLayout;
import dev.hely.tab.api.TabProvider;
import dev.hely.tab.api.skin.Skin;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by Hulk
 * at 11/10/2021 13:31
 * Project: Survival
 * Class: TablistProvider
 */

public class TablistProvider implements TabProvider {

    @Override
    public Set<TabLayout> getProvider(Player player) {
        Set<TabLayout> tabs = new HashSet<>();
        tabs.add(new TabLayout(TabColumn.LEFT, 1, "a", 1, Skin.BOW_SKIN));

        return tabs;
    }

    @Override
    public List<String> getFooter(Player player) {

        return Arrays.asList("", "Hello", "");
    }

    @Override
    public List<String> getHeader(Player player) {
        return Arrays.asList("", "Bye", "");
    }
}
