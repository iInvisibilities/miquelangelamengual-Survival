package es.hulk.survival.command.location.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class DeleteLocationCommand extends BaseCommand {

    @Command(name = "deletelocation")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        WarpManager warpManager = Survival.get().getWarpManager();

        if (args.length == 0) {
            player.sendMessage(Utils.color("&cUsage: /deletelocation <name>"));
        }

        if (args.length > 0) {
            player.sendMessage(Utils.color("&cLocation " + args[0] + " has been succesfuly removed"));
            warpManager.deleteWarpByName(args[0]);
            warpManager.saveWarps();
        }
    }
}
