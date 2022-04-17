package es.hulk.survival.command.speedrun.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 20:43
 * Project: Survival
 * Class: SpeedRunnerListCommand
 */

public class SpeedRunnerListCommand extends BaseCommand {

    @Command(name = "speedrun.list", permission = "survival.speedrun.list")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.sendMessage(Utils.color("&aLista de speedruns:"));
        for (Player online : Survival.get().getSpeedRunners()) {
            player.sendMessage(Utils.color(" &f- &e" + online.getName()));
        }
    }
}
