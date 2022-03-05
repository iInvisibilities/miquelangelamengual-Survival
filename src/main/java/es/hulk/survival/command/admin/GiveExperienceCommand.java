package es.hulk.survival.command.admin;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 05/03/2022 15:37
 * Project: Survival
 * Class: GiveExperienceCommand
 */

public class GiveExperienceCommand extends BaseCommand {

    @Command(name = "exp", permission = "survival.command.xp")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage("/exp add <xp>");
            player.sendMessage("/exp set <xp>");
            player.sendMessage("/exp remove <xp>");
        }

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("set")) {
                player.setTotalExperience(Integer.parseInt(args[1]));
                player.sendMessage(Utils.color("Has recibido xp"));
            }
            if (args[0].equalsIgnoreCase("add")) {
                player.giveExpLevels(Integer.parseInt(args[1]));
                player.sendMessage(Utils.color("Has recibido xp"));
            }
        }
    }
}
