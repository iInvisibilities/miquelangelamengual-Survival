package es.hulk.survival.utils;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class PlayerUtils {

    public static int getPlayerKills(Player player) {
        return player.getStatistic(Statistic.PLAYER_KILLS);
    }

    public static int getPlayerDeaths(Player player) {
        return player.getStatistic(Statistic.DEATHS);
    }

    public static int getMobKills(Player player) {
        return player.getStatistic(Statistic.MOB_KILLS);
    }

    public static String getPlayTime(Player player) {
        long ticks = player.getStatistic(Statistic.PLAY_ONE_MINUTE);

        long hour = ((ticks / 20) / 60) / 60;
        long minute = ticks / 1200 - hour * 60;
        return hour + ":" + minute;
    }

    public static String getOnlinePlayers() {
        return Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers();
    }

    public static int getPlayerStatistic(Player player, Statistic statistic) {
        return player.getStatistic(statistic);
    }

}
