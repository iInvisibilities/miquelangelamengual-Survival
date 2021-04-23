package es.hulk.survival.command;

import dev.risas.panda.files.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.CommandArgs;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CoordsCommand extends BaseCommand {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length < 0) {
            for (String s : mainConfig.getStringList("COORDS.NO-ARGS-COMMAND")) {
                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s));
            }
        }
        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);
            for (String s : mainConfig.getStringList("COORDS.OTHER-PLAYER-COORDS")) {
                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replaceAll("{target}", String.valueOf(target))));
            }
        }
    }
}
