package es.hulk.survival.command.essential;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class PlayTimeCommand extends BaseCommand {

    @Command(name = "playtime")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {

            long ticks = player.getStatistic(Statistic.PLAY_ONE_MINUTE);

            long hour = ((ticks / 20) / 60) / 60;
            long minute = ticks / 1200 - hour * 60;

            long fakeminute = ticks / 1200;
            long seconds = ticks / 20 - fakeminute * 60;

            player.sendMessage(Utils.color(Utils.PREFIX + "&aHas jugado un total de &e" + hour + ":" + minute + ":" + seconds + " &adentro del Servidor."));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage("Not Found");
            }

            long ticks = target.getStatistic(Statistic.PLAY_ONE_MINUTE);

            long hour = ((ticks / 20) / 60) / 60;
            long minute = ticks / 1200 - hour * 60;

            long fakeminute = ticks / 1200;
            long seconds = ticks / 20 - fakeminute * 60;

            player.sendMessage(Utils.color(Utils.PREFIX + "&aEl Jugador &e" + target.getDisplayName() + " &aha jugado un total de &e" + hour + ":" + minute + ":" + seconds + " &adentro del Servidor."));
        }
    }
}
