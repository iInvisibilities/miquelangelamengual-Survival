package es.hulk.survival.utils;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class PlayerUtils {

    public static int getPlayerKills(Player player) {
        return player.getStatistic(Statistic.PLAYER_KILLS);
    }

    public static int getDeaths(Player player) {
        return player.getStatistic(Statistic.DEATHS);
    }

    public static int getMobKills(Player player) {
        return player.getStatistic(Statistic.MOB_KILLS);
    }

    public static String getScoreboardPlayTime(Player player) {
        long ticks = player.getStatistic(Statistic.PLAY_ONE_MINUTE);

        long hour = ((ticks / 20) / 60) / 60;
        long minute = ticks / 1200 - hour * 60;
        return hour + ":" + minute;
    }

    public static String getPlayTime(Player player) {
        long ticks = player.getStatistic(Statistic.PLAY_ONE_MINUTE);

        long hour = ((ticks / 20) / 60) / 60;
        long minute = ticks / 1200 - hour * 60;

        long fakeminute = ticks / 1200;
        long seconds = ticks / 20 - fakeminute * 60;

        return hour + ":" + minute + ":" + seconds;
    }

    public static String getOnlinePlayers() {
        return Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers();
    }

    public static int getPlayerStatistic(Player player, Statistic statistic) {
        return player.getStatistic(statistic);
    }

    public static String getWorld(Player player) {
        switch (player.getLocation().getWorld().getName()) {
            case "world":
                return "Overworld";
            case "world_nether":
                return "Nether";
            case "world_the_end":
                return "The End";
            default:
                return player.getLocation().getWorld().getName();
        }
    }

    public static String getSpawnWorld() {
        FileConfig config = Survival.get().getSpawnConfig();
        if (config.getString("SPAWN_LOCATION.WORLD").equals("world")) {
            return "Overworld";
        } else if (config.getString("SPAWN_LOCATION.WORLD").equals("world_nether")) {
            return "Nether";
        } else if (config.getString("SPAWN_LOCATION.WORLD").equals("world_the_end")) {
            return "The End";
        } else {
            return "None";
        }
    }

}
