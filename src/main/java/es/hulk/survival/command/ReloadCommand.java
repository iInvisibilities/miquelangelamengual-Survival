package es.hulk.survival.command;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ReloadCommand extends BaseCommand {

    private final FileConfig mainConfig = Survival.get().getMainConfig();
    private final FileConfig scoreboardConfig = Survival.get().getScoreboardConfig();
    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();

    @Command(name = "survival.reload", permission = "survival.command.reload")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        this.mainConfig.reload();
        this.scoreboardConfig.reload();
        this.messagesConfig.reload();
        player.sendMessage(Utils.color("&aConfig has been succesfully reloaded"));
    }
}
