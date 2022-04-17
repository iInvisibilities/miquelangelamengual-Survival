package es.hulk.survival.command.speedrun.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.counter.CounterHelper;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 20:37
 * Project: Survival
 * Class: StartSpeedRunCommand
 */

public class StartSpeedRunCommand extends BaseCommand {

    @Command(name = "speedrun.start", permission = "survival.speedrun.start", inGameOnly = true)

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        Survival.get().setCounterEnabled(true);
        Survival.get().setSpeedRun(true);
        CounterHelper.startRunnable();
        player.sendMessage(Utils.color("&aScoreboard counter enabled."));
    }
}
