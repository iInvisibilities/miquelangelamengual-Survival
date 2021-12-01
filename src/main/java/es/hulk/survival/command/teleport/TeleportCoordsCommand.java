package es.hulk.survival.command.teleport;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TeleportCoordsCommand extends BaseCommand {
    private final Survival plugin = Survival.get();

    @Command(name = "tppos")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        Survival.get().setCounter(31);

            if (args.length == 0) {
                player.sendMessage(Utils.color("&cUsage: /tppos <x> <y> <z>"));
            }

            if (args.length > 3) {
                player.sendMessage(Utils.color("&cError, has puesto demasiados argumentos"));
                return;
            }
            if (args.length < 3) {
                player.sendMessage(Utils.color("&cError, no has puesto todos los argumentos"));
                return;
            }

            Location location = new Location(player.getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
            player.teleport(location);
            player.sendMessage(Utils.color(Utils.getPREFIX() + "&aTe has teletransportado a &ex: " + args[0] + " y: " + args[1] + " z: " + args[2]));

    }
}
