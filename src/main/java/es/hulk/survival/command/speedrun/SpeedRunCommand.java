package es.hulk.survival.command.speedrun;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 17:14
 * Project: Survival
 * Class: SpeedRunCommand
 */

public class SpeedRunCommand extends BaseCommand {

    @Command(name = "speedrun", aliases = {"sr"}, permission = "survival.speedrun.list")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.performCommand("speedrun help");
            return;
        }

        if (args[0].equalsIgnoreCase("toggledeathcounter")) {
            if (Survival.get().isSpeedRunDeathCounter()) {
                Survival.get().setSpeedRunDeathCounter(false);
                player.sendMessage("§cSpeedrun death counter disabled");
            } else {
                Survival.get().setSpeedRunDeathCounter(true);
                player.sendMessage("§aSpeedrun death counter enabled");
            }
            return;
        }

        if (args[0].equalsIgnoreCase("help")) {
            player.sendMessage("");
            player.sendMessage("&a&lAYUDA DE COMANDOS DE SPEEDRUN");
            player.sendMessage("");
            player.sendMessage(Utils.color("&a/speedrun add <player> &7- &fAñade un jugador a la lista de speedruns"));
            player.sendMessage(Utils.color("&a/speedrun remove <player> &7- &fQuita a un jugador a la lista de speedruns"));
            player.sendMessage(Utils.color("&a/speedrun toggledeathcounter &7- &fSi un jugador el cronometro aumentara 5 minutos por muerte"));
            player.sendMessage(Utils.color("&a/speedrun list &7- &fMuestra la lista de speedruns"));
            player.sendMessage(Utils.color("&a/speedrun clear &7- &fLimpia la lista de speedruns"));
            player.sendMessage(Utils.color("&a/speedrun start &7- &fInicia el cronometro"));
            player.sendMessage(Utils.color("&a/speedrun stop &7- &fDetiene el cronometro"));
            return;
        }

        if (args[0].equalsIgnoreCase("list")) {
            player.sendMessage(Utils.color("&aLista de speedruns:"));
            for (Player online : Survival.get().getSpeedRunners()) {
                player.sendMessage(Utils.color(" &f- &e" + online.getName()));
            }
            return;
        }

        if (args[0].equalsIgnoreCase("clear")) {
            Survival.get().getSpeedRunners().clear();
            player.sendMessage(Utils.color("&aLista de speedruns limpiada"));
            return;
        }

        if (args[0].equalsIgnoreCase("start")) {
            if (Survival.get().getSpeedRunners().size() == 0) {
                player.sendMessage(Utils.color("&cNo hay jugadores en la lista de speedruns"));
                return;
            } else {
                player.performCommand("enablecounter start");
            }
            return;
        }

        if (args[0].equalsIgnoreCase("stop")) {
            if (Survival.get().getSpeedRunners().size() == 0) {
                player.sendMessage(Utils.color("&cNo hay jugadores en la lista de speedruns"));
                return;
            } else {
                player.performCommand("enablecounter stop");
            }
            return;
        }

        Player target = Bukkit.getPlayer(args[1]);

        if (target == null) {
            player.sendMessage("§cPlayer not found");
            return;
        }

        if (args[0].equalsIgnoreCase("add")) {
            if (Survival.get().isSpeedRun()) {
                player.sendMessage("§cSpeedrun already started");
                return;
            }
            Survival.get().getSpeedRunners().add(target);
            player.sendMessage("§aAdded §7" + target.getName() + " §ato the speedrun");
        }

        if (args[0].equalsIgnoreCase("remove")) {
            if (Survival.get().isSpeedRun()) {
                player.sendMessage("§cSpeedrun already started");
                return;
            }
            Survival.get().getSpeedRunners().remove(target);
            player.sendMessage("§aAdded §7" + target.getName() + " §ato the speedrun");
        }
    }
}
