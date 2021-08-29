package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements ScoreboardAdapter {

    private final FileConfig scoreboard = Survival.get().getScoreboardConfig();

    @Override
    public String getTitle(Player player) {
        return Utils.color("&7» &a&lSurvival 1.17.1 &7«");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();

        for (String string : scoreboard.getStringList("SCOREBOARD.LINES")) {
            lines.add(string
                    .replaceAll("<displayname>", player.getDisplayName())
                    .replaceAll("<ping>", String.valueOf(player.getPing()))
                    .replaceAll("<playerKills>", String.valueOf(PlayerUtils.getPlayerKills(player)))
                    .replaceAll("<deaths>", String.valueOf(PlayerUtils.getPlayerDeaths(player)))
                    .replaceAll("<playtime>", PlayerUtils.getPlayTime(player))
                    .replaceAll("<mobKills>", String.valueOf(PlayerUtils.getMobKills(player)))
                    .replaceAll("<players>", PlayerUtils.getOnlinePlayers()));
        }

        return lines;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
