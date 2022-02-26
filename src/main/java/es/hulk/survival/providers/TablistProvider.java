package es.hulk.survival.providers;

import dev.hely.tab.TabColumn;
import dev.hely.tab.TabLayout;
import dev.hely.tab.TabProvider;
import dev.hely.tab.skin.Skin;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.location.BedLocation;
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

    private final Survival plugin = Survival.get();
    private final FileConfig config = Survival.get().getSpawnConfig();

    @Override
    public Set<TabLayout> getProvider(Player player) {
        Set<TabLayout> tabs = new HashSet<>();

        tabs.add(new TabLayout(TabColumn.LEFT, 2, "&aTus Estadisticas", Skin.getSkin(player.getUniqueId())));
        tabs.add(new TabLayout(TabColumn.LEFT, 3, "&bMobs Matados&7: &e" + PlayerUtils.getMobKills(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 4, "&bJugadores&7: &e" + PlayerUtils.getPlayerKills(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 5, "&bMuertes&7: &e" + PlayerUtils.getDeaths(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 6, "&bTiempo&7: &e" + PlayerUtils.getPlayTime(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 7, "&bVida&7: &e" + PlayerUtils.getPlayerHealth(player)));

        tabs.add(new TabLayout(TabColumn.LEFT, 10, "&aBosses Eliminados"));
        tabs.add(new TabLayout(TabColumn.LEFT, 11, "&bWhiters&7: &e" + player.getStatistic(Statistic.KILL_ENTITY, EntityType.WITHER)));
        tabs.add(new TabLayout(TabColumn.LEFT, 12, "&bEnder Dragons&7: &e" + player.getStatistic(Statistic.KILL_ENTITY, EntityType.ENDER_DRAGON)));

        tabs.add(new TabLayout(TabColumn.LEFT, 14, "&aTus Coordenadas"));
        tabs.add(new TabLayout(TabColumn.LEFT, 15, "&bMundo&7: &e" + PlayerUtils.getWorld(player), Skin.PLANET_SKIN));
        tabs.add(new TabLayout(TabColumn.LEFT, 16, "&bBioma&7: &e" + PlayerUtils.getPlayerBiome(player)));
        tabs.add(new TabLayout(TabColumn.LEFT, 17, "&bX&7: &e" + player.getLocation().getBlockX()));
        tabs.add(new TabLayout(TabColumn.LEFT, 18, "&bY&7: &e" + player.getLocation().getBlockY()));
        tabs.add(new TabLayout(TabColumn.LEFT, 19, "&bZ&7: &e" + player.getLocation().getBlockZ()));

        if (player.getBedSpawnLocation() != null) {
            tabs.add(new TabLayout(TabColumn.MIDDLE, 3, "&aCoords de tu Cama"));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 4, "&bMundo&7: &e" + BedLocation.getBedWorld(player), Skin.PLANET_SKIN));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 5, "&bX&7: &e" + BedLocation.bedCoordinateX(player)));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 6, "&bY&7: &e" + BedLocation.bedCoordinateY(player)));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 7, "&bZ&7: &e" + BedLocation.bedCoordinateZ(player)));
        }

        tabs.add(new TabLayout(TabColumn.MIDDLE, 10, "&aCoords del Spawn"));
        if (plugin.getSpawnManager().getLocation() != null) {
            tabs.add(new TabLayout(TabColumn.MIDDLE, 12, "&bX&7: &e" + config.getInt("SPAWN_LOCATION.X")));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 13, "&bY&7: &e" + config.getInt("SPAWN_LOCATION.Y")));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 14, "&bZ&7: &e" + config.getInt("SPAWN_LOCATION.Z")));
        } else {
            tabs.add(new TabLayout(TabColumn.MIDDLE, 11, "&bMundo&7: &e" + player.getWorld(), Skin.PLANET_SKIN));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 12, "&bX&7: &e" + player.getWorld().getSpawnLocation().getBlockX()));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 13, "&bY&7: &e" + player.getWorld().getSpawnLocation().getBlockY()));
            tabs.add(new TabLayout(TabColumn.MIDDLE, 14, "&bZ&7: &e" + player.getWorld().getSpawnLocation().getBlockZ()));
        }

        tabs.add(new TabLayout(TabColumn.MIDDLE, 18, "&aNuestro Discord"));
        tabs.add(new TabLayout(TabColumn.MIDDLE, 19, "&bdiscord.frostpvp.net", Skin.DISCORD_SKIN));

        tabs.add(new TabLayout(TabColumn.RIGHT, 16, "&aInformacion del Servidor", Skin.COMPASS_SKIN));
        tabs.add(new TabLayout(TabColumn.RIGHT, 17, "&bTu Ping&7: &e" + player.getPing() + "ms"));
        tabs.add(new TabLayout(TabColumn.RIGHT, 18, "&bJugadores&7: &e" + PlayerUtils.getOnlinePlayers()));
        tabs.add(new TabLayout(TabColumn.RIGHT, 19, "&bTPS&7: &e" + (int) plugin.getTpsUtil().getRoundedTPS()));

        return tabs;
    }

    @Override
    public List<String> getHeader(Player player) {
        return Arrays.asList("", "&aBienvenido &e" + player.getName() + " &aa este Survival 1.17.1", "");
    }

    @Override
    public List<String> getFooter(Player player) {

        return Arrays.asList("", "&aEn este survival podras encontrar muchas cosas", "&aLas cuales las vas a poder ver usando el comando &e/help", "");
    }
}
