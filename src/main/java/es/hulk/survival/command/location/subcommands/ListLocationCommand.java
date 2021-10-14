package es.hulk.survival.command.location.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class ListLocationCommand extends BaseCommand {

    WarpManager warpManager = Survival.get().getWarpManager();

    @Command(name = "location.list")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        Survival.get().setCounter(22);

        if (warpManager.getNames().isEmpty()) {
            player.sendMessage(Utils.color("&cNo Available Locations."));
            return;
        }

        player.sendMessage(Utils.color("&aAvailable Locations&7: &f" + warpManager.getNames().toString().replace("[", "").replace("]", "")));
    }
}
