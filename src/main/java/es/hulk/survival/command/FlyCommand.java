package es.hulk.survival.command;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.CC;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

import java.io.File;

public class FlyCommand extends BaseCommand {

    private final FileConfig mainConfig = Survival.get().getMainConfig();

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        if (player.hasPermission("survival.command.fly")) {
            if (player.getAllowFlight()) {
                player.setFlying(false);
                player.setAllowFlight(false);
                player.sendMessage(CC.translate(mainConfig.getString("FLY-COMMAND.DISABLED")));
            } else {
                player.setFlying(true);
                player.setAllowFlight(true);
                player.sendMessage(CC.translate(mainConfig.getString("FLY-COMMAND.ENABLED")));
            }
        }
    }
}