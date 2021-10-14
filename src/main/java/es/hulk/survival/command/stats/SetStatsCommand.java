package es.hulk.survival.command.stats;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 14/10/2021 9:33
 * Project: Survival
 * Class: SetStatsCommand
 */

public class SetStatsCommand extends BaseCommand {

    @Command(name = "setstats", permission = "survival.command.setstats")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        Survival.get().setCounter(27);

        if (args.length == 0) {
            player.sendMessage(Utils.color("&bPlayer Kills &7- &e/setstats <player> <kills> <int>"));
            player.sendMessage(Utils.color("&bMob Kills &7- &e /setstats <player> <mobs> <int>"));
            player.sendMessage(Utils.color("&bDeaths &7- &e /setstats <player> <deaths> <int>"));
            player.sendMessage(Utils.color("&bPlaytime &7- &e /setstats <player> <playtime> <ticks>"));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(Utils.color("&cJugador no encontrado!"));
                return;
            }

            if (args[1].equalsIgnoreCase("kills")) {
                target.setStatistic(Statistic.PLAYER_KILLS, Integer.parseInt(args[2]));
                player.sendMessage("player kills for player " + target.getName() + " has been setted up to " + args[2]);
                return;
            }

            if (args[1].equalsIgnoreCase("mobs")) {
                target.setStatistic(Statistic.MOB_KILLS, Integer.parseInt(args[2]));
                player.sendMessage("Mob kills for player " + target.getName() + " has been setted up to " + args[2]);
                return;
            }

            if (args[1].equalsIgnoreCase("deaths")) {
                target.setStatistic(Statistic.DEATHS, Integer.parseInt(args[2]));
                player.sendMessage("Deaths for player " + target.getName() + " has been setted up to " + args[2]);
                return;
            }

            if (args[1].equalsIgnoreCase("playtime")) {
                target.setStatistic(Statistic.PLAY_ONE_MINUTE, Integer.parseInt(args[2]));
                player.sendMessage("Playtime for player " + target.getName() + " has been setted up to " + args[2]);
            }
        }
    }
}
