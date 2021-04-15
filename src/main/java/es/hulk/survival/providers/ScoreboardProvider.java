package es.hulk.survival.providers;

import dev.risas.panda.files.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import me.clip.placeholderapi.PlaceholderAPI;
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

        for (String s : scoreboardConfig.getStringList("SCOREBOARD.LINES")) {
            lines.add(PlaceholderAPI.setPlaceholders(player, s));
        }
        return lines;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
