package es.hulk.survival.command.essential;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class KillCommand extends BaseCommand {

    @Command(name = "mekill")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.setHealthScale(0.0D);
        player.sendMessage(Utils.color("&aTe has muerto de cancer rata"));
    }
}
