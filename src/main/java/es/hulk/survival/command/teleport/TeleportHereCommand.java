package es.hulk.survival.command.teleport;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportHereCommand extends BaseCommand {

    @Command(name = "teleporthere", aliases = {"tphere", "s"})
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
            player.sendMessage(Utils.color("&cPlayer '" + args[0] + "' not found."));
            return;
        }

        target.teleport(player.getLocation());
        player.sendMessage(Utils.color(Utils.getPREFIX() + "&aHas teletransportado a &e" + target.getDisplayName() + " &aa tu posicion."));
        target.sendMessage(Utils.color(Utils.getPREFIX() + "&aHas sido teletransportado a &e" + player.getDisplayName()) + "&a.");
    }
}
