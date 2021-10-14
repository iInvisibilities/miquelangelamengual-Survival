package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PingCommand extends BaseCommand {

    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();

    @Command(name = "ping")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        Survival.get().setCounter(16);

        if (args.length == 0) {
            player.sendMessage(Utils.color(messagesConfig.getString("PING_COMMAND.YOURS").replaceAll("<ping>", String.valueOf(Utils.getPing(player)))));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(Utils.color(messagesConfig.getString("PING_COMMAND.ERROR").replaceAll("<target>", args[0])));
                return;
            }
            player.sendMessage(Utils.color(messagesConfig.getString("PING_COMMAND.OTHER").replaceAll("<ping>", String.valueOf(Utils.getPing(target))).replaceAll("<target>", target.getDisplayName())));
        }
    }
}
