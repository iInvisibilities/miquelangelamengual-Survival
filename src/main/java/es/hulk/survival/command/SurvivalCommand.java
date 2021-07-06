package es.hulk.survival.command;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class SurvivalCommand extends BaseCommand {

    @Command(name = "survival")

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        if (sender.hasPermission("survival.command.reload"))  {
            sender.sendMessage(Utils.color("&cUsage: /survival reload"));
            return;
        }
        sender.sendMessage(Utils.color("&aSurvival plugin made by Hulk#0226"));
    }
}
