package es.hulk.survival.command;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.location.OfflinePlayerLocation;
import es.hulk.survival.utils.location.PlayerLocation;
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

        if (args.length == 0) {
            for (String stringList : mainConfig.getStringList("COORDS.YOUR-COORDS")) {
                player.sendMessage(stringList
                        .replaceAll("<x-coord>", String.valueOf(PlayerLocation.coordinateX(player)))
                        .replaceAll("<y-coord>", String.valueOf(PlayerLocation.coordinateY(player)))
                        .replaceAll("<z-coord>", String.valueOf(PlayerLocation.coordinateZ(player)))
                        .replaceAll("<world>", PlayerLocation.getWorld(player)));
            }
        }

        if (args.length > 0) {
            OfflinePlayer offlinePlayer = Bukkit.getServer().getPlayer(args[0]);

            if (offlinePlayer == null || !offlinePlayer.hasPlayedBefore()) {
                offlinePlayer = Bukkit.getServer().getOfflinePlayer(args[0]);
                player.sendMessage(mainConfig.getString("COORDS.PLAYER-NO-EXIST").replaceAll("<target_player>", String.valueOf(offlinePlayer.getName())));
                return;
            }
            if (offlinePlayer.isOnline()) {
                for (String stringList : mainConfig.getStringList("COORDS.OTHER-PLAYER-COORDS")) {
                    player.sendMessage(stringList
                            .replaceAll("<target_player>", String.valueOf(offlinePlayer.getName()))
                            .replaceAll("<x-target-player>", String.valueOf(OfflinePlayerLocation.coordinateX(offlinePlayer)))
                            .replaceAll("<y-target-player>", String.valueOf(OfflinePlayerLocation.coordinateY(offlinePlayer)))
                            .replaceAll("<z-target-player>", String.valueOf(OfflinePlayerLocation.coordinateZ(offlinePlayer)))
                            .replaceAll("<target-world>", OfflinePlayerLocation.getWorld(offlinePlayer)));
                }
                return;
            }
            player.sendMessage(Utils.color(mainConfig.getString("COORDS.PLAYER-NOT-FOUND").
                    replaceAll("<target_player>", String.valueOf(offlinePlayer.getName()))));
        }
    }
}