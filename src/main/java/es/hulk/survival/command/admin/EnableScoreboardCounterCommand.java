package es.hulk.survival.command.admin;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class EnableScoreboardCounterCommand extends BaseCommand {

    @Command(name = "enablecounter", permission = "survival.admin.enablecounter", inGameOnly = true)

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        Survival.get().setCounterEnabled(true);
        player.sendMessage(Utils.color("&aScoreboard counter enabled."));
    }
}
