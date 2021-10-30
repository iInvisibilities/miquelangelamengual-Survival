package es.hulk.survival.command.spawn;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class SpawnChunksCoordsCommand extends BaseCommand {

    @Command(name = "spawnchunkscoords")
    @Override
    public void onCommand(CommandArgs command) {
        Survival.get().setCounter(37);
        Player player = command.getPlayer();

        player.sendMessage(Utils.color("&aCoords de los SpawnChunks"));
        player.sendMessage("");
        player.sendMessage(Utils.color("&aMundo &7: &b" + player.getWorld().getSpawnLocation().getWorld()));
        player.sendMessage(Utils.color("&aX &7: &b" + player.getWorld().getSpawnLocation().getBlockX()));
        player.sendMessage(Utils.color("&aY &7: &b" + player.getWorld().getSpawnLocation().getBlockY()));
        player.sendMessage(Utils.color("&aZ &7: &b" + player.getWorld().getSpawnLocation().getBlockZ()));
    }
}
