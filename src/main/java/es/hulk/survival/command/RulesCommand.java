package es.hulk.survival.command;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
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

        mainConfig.getStringList("RULES-COMMAND").forEach(lines -> {
            lines = Utils.color(PlaceholderAPI.setPlaceholders(player, lines));
            player.sendMessage(lines);
        });
    }
}
