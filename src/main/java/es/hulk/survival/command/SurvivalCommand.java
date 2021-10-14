package es.hulk.survival.command;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class SurvivalCommand extends BaseCommand {

    private final FileConfig mainConfig = Survival.get().getMainConfig();
    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();

    private final Survival plugin = Survival.get();

    @Command(name = "survival")

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String[] args = command.getArgs();
        Survival.get().setCounter(35);

        if (args.length == 0) {
            if (sender.hasPermission("survival.command.reload"))  {
                sender.sendMessage(Utils.color("&cUsage: /survival reload"));
                return;
            }
            sender.sendMessage(Utils.color("&aSurvival plugin made by Hulk#0226"));
        }

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("survival.command.reload")) {
                    this.mainConfig.reload();
                    this.messagesConfig.reload();

                    sender.sendMessage(Utils.color("&aConfig has been succesfully reloaded"));
                }
            }
        }
    }
}
