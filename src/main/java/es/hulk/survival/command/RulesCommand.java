package es.hulk.survival.command;

import dev.risas.panda.files.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class RulesCommand extends BaseCommand {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @Command(name = "rules")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (String lines : mainConfig.getStringList("RULES-COMMAND")) {
            player.sendMessage(Utils.color(PlaceholderAPI.setPlaceholders(player, lines)));
        }
    }
}
