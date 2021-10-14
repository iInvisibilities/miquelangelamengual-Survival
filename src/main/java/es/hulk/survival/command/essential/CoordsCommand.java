package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.location.OfflinePlayerLocation;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CoordsCommand extends BaseCommand {

    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();

    @Command(name = "coords")
    @SuppressWarnings("deprecation")
    @Override
    public void onCommand(CommandArgs command) {
        String[] args = command.getArgs();
        Player player = command.getPlayer();

        if (args.length == 0) {
            for (String stringList : messagesConfig.getStringList("COORDS_COMMAND.YOURS")) {
                player.sendMessage(stringList
                        .replaceAll("<x-coord>", String.valueOf(OfflinePlayerLocation.coordinateX(player)))
                        .replaceAll("<y-coord>", String.valueOf(OfflinePlayerLocation.coordinateY(player)))
                        .replaceAll("<z-coord>", String.valueOf(OfflinePlayerLocation.coordinateZ(player)))
                        .replaceAll("<world>", OfflinePlayerLocation.getWorld(player)));
            }
        }

        if (args.length > 0) {
            OfflinePlayer offlinePlayer = Bukkit.getServer().getPlayer(args[0]);

            if (offlinePlayer == null || !offlinePlayer.hasPlayedBefore()) {
                offlinePlayer = Bukkit.getServer().getOfflinePlayer(args[0]);
                player.sendMessage(messagesConfig.getString("COORDS_COMMAND.NO_EXIST").replaceAll("<player>", String.valueOf(offlinePlayer.getName())));
                return;
            }
            if (offlinePlayer.isOnline()) {
                if (Objects.equals(offlinePlayer.getName(), player.getName())) {
                    for (String stringList : messagesConfig.getStringList("COORDS_COMMAND.YOURS")) {
                        player.sendMessage(stringList
                                .replaceAll("<x-coord>", String.valueOf(OfflinePlayerLocation.coordinateX(player)))
                                .replaceAll("<y-coord>", String.valueOf(OfflinePlayerLocation.coordinateY(player)))
                                .replaceAll("<z-coord>", String.valueOf(OfflinePlayerLocation.coordinateZ(player)))
                                .replaceAll("<world>", OfflinePlayerLocation.getWorld(player)));
                    }
                    return;
                }
                for (String stringList : messagesConfig.getStringList("COORDS_COMMAND.OTHER_PLAYER")) {
                    player.sendMessage(stringList
                            .replaceAll("<player>", String.valueOf(offlinePlayer.getName()))
                            .replaceAll("<x-coord>", String.valueOf(OfflinePlayerLocation.coordinateX(offlinePlayer)))
                            .replaceAll("<y-coord>", String.valueOf(OfflinePlayerLocation.coordinateY(offlinePlayer)))
                            .replaceAll("<z-coord>", String.valueOf(OfflinePlayerLocation.coordinateZ(offlinePlayer)))
                            .replaceAll("<world>", OfflinePlayerLocation.getWorld(offlinePlayer)));
                }
                return;
            }
            player.sendMessage(Utils.color(messagesConfig.getString("COORDS_COMMAND.NOT_FOUND").
                    replaceAll("<player>", String.valueOf(offlinePlayer.getName()))));
        }
        Survival.get().setCounter(10);
    }
}