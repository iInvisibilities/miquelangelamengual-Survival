package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements ScoreboardAdapter {

    private final FileConfig scoreboard = Survival.get().getScoreboardConfig();

    @Override
    public String getTitle(Player player) {
        return Utils.color(scoreboard.getString("SCOREBOARD.TITLE"));
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();

        float FLOAT_TPS = (float) Survival.get().getTpsUtil().getRoundedTPS();
        int TPS = (int) FLOAT_TPS;

        for (String string : scoreboard.getStringList("SCOREBOARD.LINES")) {
            lines.add(string
                    .replaceAll("<displayname>", player.getDisplayName())
                    .replaceAll("<ping>", String.valueOf(player.getPing()))
                    .replaceAll("<playerkills>", String.valueOf(PlayerUtils.getPlayerKills(player)))
                    .replaceAll("<deaths>", String.valueOf(PlayerUtils.getPlayerDeaths(player)))
                    .replaceAll("<playtime>", PlayerUtils.getScoreboardPlayTime(player))
                    .replaceAll("<mobkills>", String.valueOf(PlayerUtils.getMobKills(player)))
                    .replaceAll("<players>", PlayerUtils.getOnlinePlayers())
                    .replaceAll("<tps>", String.valueOf(TPS)));
        }

        return lines;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
