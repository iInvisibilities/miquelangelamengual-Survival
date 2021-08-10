package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.rank.RankManager;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements ScoreboardAdapter {

    private final FileConfig scoreboardConfig = Survival.get().getScoreboardConfig();
    private final RankManager rankManager = Survival.get().getRankManager();

    @Override
    public String getTitle(Player player) {
        return Utils.color(scoreboardConfig.getString("SCOREBOARD.TITLE"));
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();

        for (String stringList : scoreboardConfig.getStringList("SCOREBOARD.LINES")) {
            lines.add(stringList
                    .replaceAll("<ping>", String.valueOf(Utils.getPing(player)))
                    .replaceAll("<player-name>", player.getDisplayName())
                    .replaceAll("<rank-prefix>", rankManager.getRank().getPrefix(player))
                    .replaceAll("<rank-suffix>", rankManager.getRank().getSuffix(player))
                    .replaceAll("<rank-name>", rankManager.getRank().getName(player))
                    .replaceAll("<online-players>", String.valueOf(Bukkit.getServer().getOnlinePlayers().size()))
                    .replaceAll("<rank-displayname>", rankManager.getRank().getDisplayName(player)));
        }
        return lines;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
