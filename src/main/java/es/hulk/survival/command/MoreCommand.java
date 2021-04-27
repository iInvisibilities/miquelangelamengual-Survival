package es.hulk.survival.command;

import dev.risas.panda.files.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class MoreCommand extends BaseCommand {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @Command(name = "more", permission = "survival.command.more")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.getInventory().getItemInMainHand().setAmount(64);
        player.sendMessage(Utils.color(mainConfig.getString("MORE-COMMAND")));
    }
}