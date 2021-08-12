package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class DiscordCommand extends BaseCommand {

    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();
    @Command(name = "discord")

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        for (String list : messagesConfig.getStringList("DISCORD_COMMAND.MESSAGE")) {
            sender.sendMessage(Utils.color(list));
        }
    }
}
