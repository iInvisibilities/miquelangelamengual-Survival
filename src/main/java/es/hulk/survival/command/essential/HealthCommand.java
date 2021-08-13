package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HealthCommand extends BaseCommand {

    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();
    @Command(name = "health", aliases = "vida")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(Utils.color(messagesConfig.getString("HEALTH_COMMAND.YOURS").replace("<health>", String.valueOf((int) player.getHealth()))));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(Utils.color(messagesConfig.getString("HEALTH_COMMAND.ERROR").replace("<target>", args[0])));
                return;
            }

            if (target.equals(player)) {
                player.sendMessage(Utils.color(messagesConfig.getString("HEALTH_COMMAND.YOURS").replace("<health>", String.valueOf((int) player.getHealth()))));
                return;
            }
            player.sendMessage(Utils.color(messagesConfig.getString("HEALTH_COMMAND.OTHER").replace("<health>", String.valueOf((int) target.getHealth())).replace("<player>", target.getDisplayName())));
        }
    }
}
