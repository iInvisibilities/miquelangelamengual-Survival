package es.hulk.survival.command.speedrun.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 20:37
 * Project: Survival
 * Class: StopSpeedRunCommand
 */

public class StopSpeedRunCommand extends BaseCommand {

    @Command(name = "speedrun.stop", permission = "survival.speedrun.stop", inGameOnly = true)

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        Bukkit.getScheduler().cancelTasks(Survival.get());
        Survival.get().setSpeedRun(false);
        Survival.get().setCounterEnabled(false);
        player.sendMessage(Utils.color("&cScoreboard counter disabled."));
    }
}
