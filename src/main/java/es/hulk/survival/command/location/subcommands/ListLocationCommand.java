package es.hulk.survival.command.location.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class ListLocationCommand extends BaseCommand {

    private WarpManager warpManager = Survival.get().getWarpManager();

    @Command(name = "location.list")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (warpManager.getNames() == null) {
            player.sendMessage(Utils.color("&cNo Available Locations"));
            return;
        }

        if (warpManager.getNames() != null) {
            player.sendMessage(Utils.color("&aAvailable Warps&7:"));
            for (String s : warpManager.getNames()) {
                player.sendMessage(Utils.color(" &7* &f" + s));
            }
        }
    }
}
