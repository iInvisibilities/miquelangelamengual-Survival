package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.rank.LuckPermsAPI;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements ScoreboardAdapter {

    private final FileConfig scoreboardConfig = Survival.get().getScoreboardConfig();

    @Override
    public String getTitle(Player player) {
        return Utils.color(PlaceholderAPI.setPlaceholders(player, scoreboardConfig.getString("SCOREBOARD.TITLE")));
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();

        for (String stringList : scoreboardConfig.getStringList("SCOREBOARD.LINES")) {
            lines.add(stringList
                    .replaceAll("<ping>", String.valueOf(Utils.getPing(player)))
                    .replaceAll("<player-name>", player.getDisplayName())
                    .replaceAll("<rank-prefix>", LuckPermsAPI.getPrefix(player))
                    .replaceAll("<rank-suffix>", LuckPermsAPI.getSuffix(player))
                    .replaceAll("<rank-name>", LuckPermsAPI.getName(player))
                    .replaceAll("<online-players>", String.valueOf(Bukkit.getServer().getOnlinePlayers().size()))
                    .replaceAll("<rank-displayname>", LuckPermsAPI.getDisplayName(player)));
        }
        return lines;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
