package es.hulk.survival.command.location;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.*;
import org.bukkit.entity.Player;

public class SetLocationCommand extends BaseCommand {

    @Command(name = "setlocation")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        WarpManager warpManager = Survival.get().getWarpManager();

        if (args.length == 0) {
            player.sendMessage(Utils.color("&cUsage: /setlocation <name>"));
        }

        if (args.length > 0) {
            player.sendMessage(Utils.color("&aLocation for " + args[0] + " has been succesfuly setted"));
            warpManager.createWarp(args[0], player.getLocation());
            warpManager.saveWarps();
        }
    }


}
