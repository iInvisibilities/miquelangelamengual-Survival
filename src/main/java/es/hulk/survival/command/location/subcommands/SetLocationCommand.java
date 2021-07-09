package es.hulk.survival.command.location.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

import java.util.Locale;

public class SetLocationCommand extends BaseCommand {

    private WarpManager warpManager = Survival.get().getWarpManager();

    @Command(name = "setlocation")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(Utils.color("&cUsage: /setlocation <name>"));
        }

        if (args.length > 0) {
            player.sendMessage(Utils.color("&aLocation " + args[0] + " has been succesfuly setted"));
            warpManager.createWarp(args[0].toLowerCase(Locale.ROOT), player.getLocation());
            warpManager.saveWarps();
        }
    }


}
