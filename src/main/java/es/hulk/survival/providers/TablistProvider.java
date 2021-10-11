package es.hulk.survival.providers;

import dev.hely.tab.api.Tab;
import dev.hely.tab.api.TabColumn;
import dev.hely.tab.api.TabLayout;
import dev.hely.tab.api.TabProvider;
import dev.hely.tab.api.skin.Skin;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.location.BedLocation;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
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

        tabs.add(new TabLayout(TabColumn.LEFT, 2, "&aTus Estadisticas"));
        tabs.add(new TabLayout(TabColumn.LEFT, 3, "&bMobs Matados&7: &e" + PlayerUtils.getMobKills(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 4, "&bJugadores&7: &e" + PlayerUtils.getPlayerKills(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 5, "&bMuertes&7: &e" + PlayerUtils.getDeaths(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 6, "&bTiempo&7: &e" + PlayerUtils.getPlayTime(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 7, "&bVida&7: &e" + player.getHealth()));

        tabs.add(new TabLayout(TabColumn.LEFT, 10, "&aBosses Eliminados"));
        tabs.add(new TabLayout(TabColumn.LEFT, 11, "&bWhiters&7: &e" + player.getStatistic(Statistic.KILL_ENTITY, EntityType.WITHER)));
        tabs.add(new TabLayout(TabColumn.LEFT, 12, "&bEnder Dragons&7: &e" + player.getStatistic(Statistic.KILL_ENTITY, EntityType.ENDER_DRAGON)));

        tabs.add(new TabLayout(TabColumn.LEFT, 15, "&aTus Coordenadas"));
        tabs.add(new TabLayout(TabColumn.LEFT, 16, "&bMundo&7: &e" + PlayerUtils.getWorld(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 17, "&bX&7: &e" + player.getLocation().getBlockX()));
        tabs.add(new TabLayout(TabColumn.LEFT, 18, "&bY&7: &e" + player.getLocation().getBlockY()));
        tabs.add(new TabLayout(TabColumn.LEFT, 19, "&bZ&7: &e" + player.getLocation().getBlockZ()));

        if (player.getBedSpawnLocation() != null) {
            tabs.add(new TabLayout(TabColumn.MIDDLE, 3, "&aCoords de tu Cama"));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 4, "&bMundo&7: &e" + BedLocation.getBedWorld(player)));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 5, "&bX&7: &e" + BedLocation.bedCoordinateX(player)));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 6, "&bY&7: &e" + BedLocation.bedCoordinateY(player)));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 7, "&bZ&7: &e" + BedLocation.bedCoordinateZ(player)));
        }


        return tabs;
    }

    @Override
    public List<String> getHeader(Player player) {
        return Arrays.asList("", "Hello", "");
    }

    @Override
    public List<String> getFooter(Player player) {

        return Arrays.asList("", "Bye", "");
    }
}
