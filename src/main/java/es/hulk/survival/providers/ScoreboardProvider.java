package es.hulk.survival.providers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class ScoreboardProvider implements ScoreboardAdapter {

    @Override
    public String getTitle(Player player) {
        return Utils.color("&a&lSurvival &7| &f1.18.1");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        lines.add("&7" + fullDateHour());
        lines.add("");
        lines.add("&e&lJugadores: ");
        for (Player online : Bukkit.getOnlinePlayers()) {
            lines.add(" &7* &a" + online.getName() + "&7: &f" + PlayerUtils.getDeaths(online));
        }
        lines.add("");
        lines.add("&e&lServidor: ");
        lines.add(" &7* &aTotal&7: &f" + Bukkit.getOnlinePlayers().size());
        lines.add(" &7* &aTPS&7: &f" + (int) Survival.get().getTpsUtil().getRoundedTPS());
        lines.add("");
        lines.add("&7frostpvp.net");
        return Utils.translate(lines);
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }

    private String fullDateHour() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CEST"));
        return dateFormat.format(now);
    }
}
