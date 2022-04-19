package es.hulk.survival.command.admin;

import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 19/04/2022 12:33
 * Project: Survival
 * Class: WorldInfoCommand
 */

public class WorldInfoCommand extends BaseCommand {

    @Command(name = "worldinfo", aliases = {"wi"}, permission = "survival.admin.worldinfo")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.sendMessage("World: " + player.getWorld().getName());
    }
}
