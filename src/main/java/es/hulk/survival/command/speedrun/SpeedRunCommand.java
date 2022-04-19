package es.hulk.survival.command.speedrun;

import es.hulk.survival.command.speedrun.subcommands.*;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 17:14
 * Project: Survival
 * Class: SpeedRunCommand
 */

public class SpeedRunCommand extends BaseCommand {

    public SpeedRunCommand() {
        new StartSpeedRunCommand();
        new StopSpeedRunCommand();
        new ClearSpeedRunnersCommand();
        new ToggleDeathCounterCommand();
        new SpeedRunnerListCommand();
        new AddSpeedRunnerCommand();
        new RemoveSpeedRunnerCommand();
    }

    @Command(name = "speedrun", aliases = {"sr"}, permission = "survival.speedrun.list")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            this.sendHelp(player);
            return;
        }

        if (args[0].equalsIgnoreCase("help")) {
            this.sendHelp(player);
        }
    }

    private void sendHelp(Player player) {
        player.sendMessage(Utils.getLINE());
        player.sendMessage(Utils.color("&a&lAYUDA DE COMANDOS DE SPEEDRUN"));
        player.sendMessage(Utils.getLINE());
        player.sendMessage(Utils.color("&a/speedrun add <player> &7- &fAñade un jugador a la lista de speedruns"));
        player.sendMessage(Utils.color("&a/speedrun remove <player> &7- &fQuita a un jugador a la lista de speedruns"));
        player.sendMessage(Utils.color("&a/speedrun deathcounter &7- &fSi un jugador el cronometro aumentara 5 minutos por muerte"));
        player.sendMessage(Utils.color("&a/speedrun list &7- &fMuestra la lista de speedruns"));
        player.sendMessage(Utils.color("&a/speedrun clear &7- &fLimpia la lista de speedruns"));
        player.sendMessage(Utils.color("&a/speedrun start &7- &fInicia el cronometro"));
        player.sendMessage(Utils.color("&a/speedrun stop &7- &fDetiene el cronometro"));
        player.sendMessage(Utils.getLINE());
    }
}
