package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class FlyCommand extends BaseCommand {

    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();

    @Command(name = "fly")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        if (player.getPlayerTime() == 10.00) {
            if (!player.getAllowFlight()) {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(Utils.color(messagesConfig.getString("FLY_COMMAND.ENABLED")));
            } else {
                player.setFlying(false);
                player.setAllowFlight(false);
                player.sendMessage(Utils.color(messagesConfig.getString("FLY_COMMAND.DISABLED")));
            }
        } else {
            player.sendMessage(Utils.color("&cNoup."));
        }

    }
}