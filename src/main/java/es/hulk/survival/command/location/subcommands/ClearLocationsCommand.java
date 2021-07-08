package es.hulk.survival.command.location.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class ClearLocationsCommand extends BaseCommand {

    @Command(name = "location.clear", permission = "survival.command.clearlocations")
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender commandSender = command.getSender();
        WarpManager warpManager = Survival.get().getWarpManager();

        warpManager.clearWarp();
        commandSender.sendMessage(Utils.color("&aSuccesfully cleared all saved locations"));
    }
}
