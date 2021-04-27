package es.hulk.survival.command;

import dev.risas.panda.files.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class CoordsCommand extends BaseCommand {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @Command(name = "coords")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            for (String s : mainConfig.getStringList("COORDS.NO-ARGS-COMMAND")) {
                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s));
            }
        }
        if (args.length > 0) {
            OfflinePlayer pTo = Bukkit.getServer().getPlayer(args[0]);

            if (pTo == null) {
                pTo = Bukkit.getServer().getOfflinePlayer(args[0]);
            }

            if (pTo == null || !pTo.hasPlayedBefore()) {
                player.sendMessage(mainConfig.getString("COORDS.PLAYER-NO-EXIST").replaceAll("%target_player%", String.valueOf(pTo.getName())));
            } else {
                if (pTo.isOnline()) {
                    for (String s : mainConfig.getStringList("COORDS.OTHER-PLAYER-COORDS")) {
                        player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replaceAll("%target_player%", String.valueOf(pTo.getName()))));
                    }
                } else {
                    player.sendMessage(Utils.color(mainConfig.getString("COORDS.PLAYER-NOT-FOUND").
                            replaceAll("%target_player%", String.valueOf(pTo.getName()))));
                }
            }
        }
    }
}