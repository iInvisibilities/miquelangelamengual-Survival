package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.PlayerUtils;
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
        return Utils.color("&aContador De Muertes");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        lines.add("");
        for (Player online : Bukkit.getOnlinePlayers()) {
            lines.add("&b" + online.getName() + "&7: &e" + PlayerUtils.getDeaths(online));
        }
        lines.add("");
        lines.add("&bTPS&7: &e" + Survival.get().getTpsUtil().getRoundedTPS());
        lines.add("");
        lines.add("&7frostpvp.net");
        return Utils.translate(lines);
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
