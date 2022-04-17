package es.hulk.survival.command.speedrun.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 20:41
 * Project: Survival
 * Class: ToggleDeathCounterCommand
 */

public class ToggleDeathCounterCommand extends BaseCommand {

    @Command(name = "speedrun.deathcounter", permission = "speedrun.deathcounter")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (Survival.get().isSpeedRunDeathCounter()) {
            Survival.get().setSpeedRunDeathCounter(false);
            player.sendMessage("§cSpeedrun death counter disabled");
        } else {
            Survival.get().setSpeedRunDeathCounter(true);
            player.sendMessage("§aSpeedrun death counter enabled");
        }
    }
}
