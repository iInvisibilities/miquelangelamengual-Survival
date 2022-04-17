package es.hulk.survival.command.speedrun;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.counter.CounterHelper;
import es.hulk.survival.utils.counter.TimerRunnable;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScoreboardCounterCommand extends BaseCommand {

    @Command(name = "enablecounter", permission = "survival.admin.enablecounter", inGameOnly = true)

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(Utils.color("&cUsage: /enablecounter <start|stop>"));
            return;
        }

        if (args[0].equalsIgnoreCase("start")) {
            Survival.get().setCounterEnabled(true);
            Survival.get().setSpeedRun(true);
            CounterHelper.startRunnable();
            player.sendMessage(Utils.color("&aScoreboard counter enabled."));
            return;
        }

        if (args[0].equalsIgnoreCase("stop")) {
            Bukkit.getScheduler().cancelTasks(Survival.get());
            Survival.get().setSpeedRun(false);
            Survival.get().setCounterEnabled(false);
            player.sendMessage(Utils.color("&cScoreboard counter disabled."));
        }
    }
}
