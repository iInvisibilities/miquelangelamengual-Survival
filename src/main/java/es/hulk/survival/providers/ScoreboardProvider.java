package es.hulk.survival.providers;

import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements ScoreboardAdapter {

    @Override
    public String getTitle(Player player) {
        return Utils.color("&7» &a&lSurvival 1.17.1 &7«");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();

        lines.add("");
        lines.add("&eNombre&7: &f" + player.getDisplayName());
        lines.add("&ePing&7: &f" + player.getPing() + "ms");
        lines.add("");
        lines.add("&eAsesinatos&7: &f" + PlayerUtils.getPlayerKills(player));
        lines.add("&eMuertes&7: &f" + PlayerUtils.getPlayerDeaths(player));
        lines.add("&eTiempo Jugado&7: &f" + PlayerUtils.getPlayTime(player));
        lines.add("&eMobs Matados&7: &f" + PlayerUtils.getMobKills(player));
        lines.add("");
        lines.add("&eJugadores&7: &f" + PlayerUtils.getOnlinePlayers());
        lines.add("");
        lines.add("&7frostpvp.net");

        return lines;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
