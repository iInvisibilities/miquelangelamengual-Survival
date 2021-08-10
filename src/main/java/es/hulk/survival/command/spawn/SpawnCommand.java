package es.hulk.survival.command.spawn;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class SpawnCommand extends BaseCommand {

    @Command(name = "spawn")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (Survival.get().getSpawnManager().hasSpawn()) {
            player.teleport(Survival.get().getSpawnManager().getSpawnLocation());
            player.sendMessage(Utils.color("&cRetard, the spawn location hasnt setted up, now go cry"));
            return;
        }
        player.teleport(Survival.get().getSpawnManager().getSpawnLocation());
        player.sendMessage(Utils.color("&aTeleported to Spawn"));
    }
}
