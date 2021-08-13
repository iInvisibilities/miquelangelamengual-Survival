package es.hulk.survival.command.admin;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SetNameCommand extends BaseCommand {

    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();
    @Command(name = "setname", permission = "survival.command.setname")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(Utils.LINE);
            player.sendMessage(Utils.color("&aSetName Help"));
            player.sendMessage(Utils.color(""));
            player.sendMessage(Utils.color("&a/setname <player> <name> &7- &fSets the name for a player"));
            player.sendMessage(Utils.color("&a/setname <name> &7- &fChanges your own name"));
            player.sendMessage(Utils.color("&a/setname reset [player] &7- &fResets to the default name"));
            player.sendMessage(Utils.color(""));
            player.sendMessage(Utils.color("[player] es opcional "));
            player.sendMessage(Utils.LINE);
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reset")) {
                player.setDisplayName(player.getName());
                player.setPlayerListName(player.getName());
                player.sendMessage(Utils.color(messagesConfig.getString("SETNAME_COMMAND.RESET")));
                return;
            }
            player.setDisplayName(args[0]);
            player.setPlayerListName(args[0]);
            player.sendMessage(Utils.color(messagesConfig.getString("SETNAME_COMMAND.YOURS")
                    .replace("<name>", args[0])));
        }

        if (args.length > 0) {
            Player name = Bukkit.getPlayer(args[1]);

            if (args[0].equalsIgnoreCase("reset")) {

                if (name == null) {
                    player.sendMessage(Utils.color(messagesConfig.getString("SETNAME_COMMAND.ERROR").replace("<player>", args[1])));
                    return;
                }

                name.setDisplayName(name.getName());
                name.setPlayerListName(name.getName());
                player.sendMessage(Utils.color(messagesConfig.getString("SETNAME_COMMAND.RESET-OTHER")
                        .replace("<target>", name.getName())));
                return;
            }
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(Utils.color(messagesConfig.getString("SETNAME_COMMAND.ERROR").replace("<player>", args[0])));
                return;
            }

            target.setDisplayName(args[1]);
            target.setPlayerListName(args[1]);
            player.sendMessage(Utils.color(messagesConfig.getString("SETNAME_COMMAND.OTHER").replace("<target>", target.getName()).replace("<name>", args[1])));
        }
    }
}
