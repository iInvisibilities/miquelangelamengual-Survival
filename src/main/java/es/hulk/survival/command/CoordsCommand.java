package es.hulk.survival.command;

import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.location.OfflinePlayerLocation;
import es.hulk.survival.utils.location.PlayerLocation;
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
        String[] args = command.getArgs();

        Player player = command.getPlayer();
        OfflinePlayer offlinePlayer = Bukkit.getServer().getPlayer(args[0]);

        if (args.length == 0) {
            for (String s : mainConfig.getStringList("COORDS.NO-ARGS-COMMAND")) {
                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s)
                        .replaceAll("<x-coord>", PlayerLocation.coordinateX(player))
                        .replaceAll("<y-coord>", PlayerLocation.coordinateY(player))
                        .replaceAll("<z-coord>", PlayerLocation.coordinateZ(player))
                        .replaceAll("<world>", PlayerLocation.getWorld(player)));
            }
        }

        if (args.length > 0) {
            if (offlinePlayer == null || !offlinePlayer.hasPlayedBefore()) {
                player.sendMessage(mainConfig.getString("COORDS.PLAYER-NO-EXIST")
                        .replaceAll("<target_player>", String.valueOf(offlinePlayer.getName())));
                return;
            }
            if (offlinePlayer.isOnline()) {
                for (String s : mainConfig.getStringList("COORDS.OTHER-PLAYER-COORDS")) {
                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s
                            .replaceAll("<target_player>", String.valueOf(offlinePlayer.getName()))
                            .replaceAll("<x-target-player>", OfflinePlayerLocation.coordinateX(offlinePlayer))
                            .replaceAll("<y-target-player>", OfflinePlayerLocation.coordinateY(offlinePlayer))
                            .replaceAll("<z-target-player>", OfflinePlayerLocation.coordinateZ(offlinePlayer))
                            .replaceAll("<target-world>", OfflinePlayerLocation.getWorld(offlinePlayer))));
                }
            } else {
                player.sendMessage(Utils.color(mainConfig.getString("COORDS.PLAYER-NOT-FOUND").
                        replaceAll("<target_player>", String.valueOf(offlinePlayer.getName()))));
            }
        }
    }
}