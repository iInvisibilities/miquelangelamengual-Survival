package es.hulk.survival.command;

import es.hulk.survival.utils.FileConfig;
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
    @SuppressWarnings("deprecation")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            for (String s : mainConfig.getStringList("COORDS.NO-ARGS-COMMAND")) {
                String x = String.valueOf(player.getLocation().getX());
                String y = String.valueOf(player.getLocation().getY());
                String z = String.valueOf(player.getLocation().getZ());
                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s).replaceAll("<x-coord>", x).replaceAll("<y-coord>", y).replaceAll("<z-coord>", z));
            }
        }
        if (args.length > 0) {
            OfflinePlayer offlinePlayer = Bukkit.getServer().getPlayer(args[0]);

            if (offlinePlayer == null || !offlinePlayer.hasPlayedBefore()) {
                player.sendMessage(mainConfig.getString("COORDS.PLAYER-NO-EXIST").replaceAll("%target_player%", String.valueOf(offlinePlayer.getName())));
                return;
            }
            if (offlinePlayer.isOnline()) {
                for (String s : mainConfig.getStringList("COORDS.OTHER-PLAYER-COORDS")) {
                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replaceAll("%target_player%", String.valueOf(offlinePlayer.getName()))));
                }
            } else {
                player.sendMessage(Utils.color(mainConfig.getString("COORDS.PLAYER-NOT-FOUND").
                        replaceAll("%target_player%", String.valueOf(offlinePlayer.getName()))));
            }
        }
    }
}