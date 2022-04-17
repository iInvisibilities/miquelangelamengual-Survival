package es.hulk.survival.command.speedrun.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 20:39
 * Project: Survival
 * Class: ClearSpeedRunnersCommand
 */

public class ClearSpeedRunnersCommand extends BaseCommand {

    @Command(name = "speedrun.clear", permission = "survival.speedrun.clear")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        Survival.get().getSpeedRunners().clear();
        player.sendMessage(Utils.color("&aLista de speedruns limpiada"));
    }
}
