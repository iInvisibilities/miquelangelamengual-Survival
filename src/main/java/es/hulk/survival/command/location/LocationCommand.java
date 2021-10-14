package es.hulk.survival.command.location;

import es.hulk.survival.Survival;
import es.hulk.survival.command.location.subcommands.ClearLocationsCommand;
import es.hulk.survival.command.location.subcommands.DeleteLocationCommand;
import es.hulk.survival.command.location.subcommands.ListLocationCommand;
import es.hulk.survival.command.location.subcommands.SetLocationCommand;
import es.hulk.survival.managers.warp.Warp;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class LocationCommand extends BaseCommand {

    public LocationCommand() {
        new DeleteLocationCommand();
        new SetLocationCommand();
        new ListLocationCommand();
        new ClearLocationsCommand();
    }

    private WarpManager warpManager = Survival.get().getWarpManager();

    @Command(name = "location")

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender commandSender = command.getSender();
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        Survival.get().setCounter(24);

        if (args.length == 0) {
            getUsage(commandSender);
        }

        if (args.length > 0) {
            Warp warp = warpManager.getWarpByName(args[0].toLowerCase(Locale.ROOT));
            if (args[0].equalsIgnoreCase("help")) {
                getUsage(commandSender);
                return;
            }

            if (warp == null) {
                player.sendMessage(Utils.color("&cThis location dont exist"));
                return;
            }
            player.sendMessage(Utils.color("&aSuccesfully teleported to " + args[0] + " location."));
            player.teleport(warp.getLocation());

        }
    }

    public void getUsage(CommandSender commandSender) {
        commandSender.sendMessage(Utils.getLINE());
        commandSender.sendMessage(Utils.color("&e/setlocation <name> &7- &fSets your current location"));
        commandSender.sendMessage(Utils.color("&e/deletelocation <name> &7- &fRemoves the location you want"));
        commandSender.sendMessage(Utils.color("&e/location help &7- &fshows this help"));
        commandSender.sendMessage(Utils.color("&e/location list &7- &fshows available locations to go"));
        commandSender.sendMessage(Utils.color("&e/location <name> &7- &fGoes to the desired location"));
        if (commandSender.hasPermission("survival.command.warp.admin")) {
            commandSender.sendMessage(Utils.color("&e/location clear &7- &fClear all the saved locations"));
        }
        commandSender.sendMessage(Utils.getLINE());
    }
}
