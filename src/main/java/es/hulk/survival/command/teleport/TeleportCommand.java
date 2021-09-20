package es.hulk.survival.command.teleport;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportCommand extends BaseCommand {

    @Command(name = "teleport", aliases = "tp")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length < 1) {
            player.sendMessage(Utils.color("&cUsage: /" + command.getLabel() + " <player>"));
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(Utils.color("&cPlayer not found"));
            return;
        }

        player.teleport(target.getLocation());
        player.sendMessage(Utils.color(Utils.getPREFIX() + "&aTe has teletransportado a &e" + target.getDisplayName()));
    }
}
