package es.hulk.survival.command.speedrun.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.TimeUtil;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.counter.CounterHelper;
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
        Bukkit.broadcastMessage(Utils.color("&cEl Speedrun ha terminado en &f" + TimeUtil.convert(CounterHelper.getTimer().getSeconds()) + "&a."));
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.sendTitle(Utils.color("&c&lSPEEDRUN ACABADO"), Utils.color("&cEl Cronometro ha terminado en &f" + TimeUtil.convert(CounterHelper.getTimer().getSeconds())), 20, 30, 30);
        }
        player.sendMessage(Utils.color("&cThe Speedrun has been stopped."));
    }
}
