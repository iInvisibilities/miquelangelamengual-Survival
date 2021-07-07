package es.hulk.survival.command.location;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.Warp;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.CC;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.command.Completer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class LocationCommand extends BaseCommand {

    private WarpManager warpManager = Survival.get().getWarpManager();
    @Command(name = "location")

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender commandSender = command.getSender();
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            getUsage(commandSender);
        }

        if (args.length > 0) {
            Warp warp = warpManager.getWarpByName(args[0]);
            if (args[0].equalsIgnoreCase("help")) {
                getUsage(commandSender);
                return;
            }
            player.teleport(warp.getLocation());
            player.sendMessage(Utils.color("Succesfully teleported to " + args[0] + " location."));
        }
    }

    public void getUsage(CommandSender commandSender) {
        commandSender.sendMessage(Utils.color(CC.LINE));
        commandSender.sendMessage(Utils.color("&e/setlocation &7- &fSets the coords as your location"));
        commandSender.sendMessage(Utils.color("&e/location help &7- &fshows this help"));
        commandSender.sendMessage(Utils.color("&e/location list &7- &fshows available locations to go"));
        commandSender.sendMessage(Utils.color("&e/location <name> &7- &fGoes to the desired location"));
        commandSender.sendMessage(Utils.color(CC.LINE));
    }

    @Completer(name = "location")
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        return warpManager.getWarpListByName();
    }
}
