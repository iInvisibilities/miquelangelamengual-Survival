package es.hulk.survival.providers;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements ScoreboardAdapter {

    @Override
    public String getTitle(Player player) {
        return Utils.color("&aEstadisticas");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        lines.add("");
        for (Player online : Bukkit.getOnlinePlayers()) {
            lines.add("&b" + online.getName() + " &7| &c" + (int) online.getHealth() + "❤");
            lines.add(" &7* &aAsesinatos&7: &e" + online.getStatistic(Statistic.MOB_KILLS));
            lines.add(" &7* &aMuertes&7: &e" + online.getStatistic(Statistic.DEATHS));
            lines.add("");
        }
        lines.add("&7frostpvp.net");

        return Utils.translate(lines);
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
