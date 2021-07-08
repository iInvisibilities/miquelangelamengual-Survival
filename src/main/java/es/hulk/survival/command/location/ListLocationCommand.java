package es.hulk.survival.command.location;

import com.sun.corba.se.impl.logging.UtilSystemException;
import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

import java.util.Collections;

public class ListLocationCommand extends BaseCommand {

    WarpManager warpManager = Survival.get().getWarpManager();

    @Command(name = "location.list")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.sendMessage(Utils.color("&aAvailable Warps&7: &f" + Collections.singletonList(warpManager.getWarps())));
    }
}
