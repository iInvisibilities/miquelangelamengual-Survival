package es.hulk.survival.command.location;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class ListLocationsCommand extends BaseCommand {

    private WarpManager warpManager = Survival.get().getWarpManager();

    @Command(name = "locations.list")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.sendMessage(Utils.color("&aAvailable Locations&7: " + warpManager.getWarpListByName()));
    }
}
