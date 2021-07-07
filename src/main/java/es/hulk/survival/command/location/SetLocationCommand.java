package es.hulk.survival.command.location;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.*;
import org.bukkit.entity.Player;

import java.util.List;

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
            List<String> nombres = Survival.get().getConfig().getStringList("WARP.LIST");
            player.sendMessage(Utils.color("&aLocation " + args[0] + " has been succesfuly setted"));
            warpManager.createWarp(args[0], player.getLocation());
            nombres.add(args[0]);
            Survival.get().saveConfig();
            warpManager.saveWarps();
        }
    }


}
