package es.hulk.survival.command.admin;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.runnable.TimerRunnable;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class EnableScoreboardCounterCommand extends BaseCommand {

    @Command(name = "enablecounter", permission = "survival.admin.enablecounter", inGameOnly = true)

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        TimerRunnable timer = Survival.get().getTimerRunnable();
        timer.runTaskTimerAsynchronously(Survival.get(), 0, 20);
        Survival.get().setCounterEnabled(true);
        player.sendMessage(Utils.color("&aScoreboard counter enabled."));
    }
}
