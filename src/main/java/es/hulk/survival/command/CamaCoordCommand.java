package es.hulk.survival.command;

import dev.risas.panda.files.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class CamaCoordCommand extends BaseCommand {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @Command(name = "camacoords")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (String s : mainConfig.getStringList("CAMA-COORDS-COMMAND")) {
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s));
        }
    }
}
