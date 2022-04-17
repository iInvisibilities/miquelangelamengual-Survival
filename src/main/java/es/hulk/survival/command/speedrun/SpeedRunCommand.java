package es.hulk.survival.command.speedrun;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 17:14
 * Project: Survival
 * Class: SpeedRunCommand
 */

public class SpeedRunCommand extends BaseCommand {

    @Command(name = "speedrun", aliases = {"sr"}, permission = "survival.speedrun.list")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage("§c/speedrun <add|remove> <player>");
            return;
        }
        Player target = Bukkit.getPlayer(args[1]);

        if (target == null) {
            player.sendMessage("§cPlayer not found");
            return;
        }

        if (args[0].equalsIgnoreCase("add")) {
            if (Survival.get().isSpeedRun()) {
                player.sendMessage("§cSpeedrun already started");
                return;
            }
            Survival.get().getSpeedRunners().add(target);
            player.sendMessage("§aAdded §7" + target.getName() + " §ato the speedrun");
        }

        if (args[0].equalsIgnoreCase("remove")) {
            if (Survival.get().isSpeedRun()) {
                player.sendMessage("§cSpeedrun already started");
                return;
            }
            Survival.get().getSpeedRunners().remove(target);
            player.sendMessage("§aAdded §7" + target.getName() + " §ato the speedrun");
        }
    }
}
