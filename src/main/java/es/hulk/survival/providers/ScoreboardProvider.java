package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements ScoreboardAdapter {

    private final FileConfig scoreboardConfig = Survival.get().getScoreboardConfig();

    @Override
    public String getTitle(Player player) {
        return Utils.color(scoreboardConfig.getString("SCOREBOARD.TITLE"));
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();

        long ticks = player.getStatistic(Statistic.PLAY_ONE_MINUTE);

        long hour = ((ticks / 20) / 60) / 60;
        long minute = ticks / 1200 - hour * 60;

        for (String stringList : scoreboardConfig.getStringList("SCOREBOARD.LINES")) {
            lines.add(stringList
                    .replaceAll("<player-name>", player.getDisplayName())
                    .replaceAll("<ping>", String.valueOf(Utils.getPing(player)))

                    .replaceAll("<kills>", String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)))
                    .replaceAll("<deaths>", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                    .replaceAll("<mobkills>", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                    .replace("<playtime>", hour + ":" + minute)

                    .replaceAll("<online-players>", String.valueOf(Bukkit.getServer().getOnlinePlayers().size()))
                    .replaceAll("<maxplayers>", String.valueOf(Bukkit.getServer().getMaxPlayers())));
        }

        return lines;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
