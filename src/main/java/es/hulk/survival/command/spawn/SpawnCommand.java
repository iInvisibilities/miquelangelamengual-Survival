package es.hulk.survival.command.spawn;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class SpawnCommand extends BaseCommand {

    private final Survival plugin = Survival.get();

    @Command(name = "spawn")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (plugin.getSpawnManager().hasSpawn()) player.teleport(plugin.getSpawnManager().getSpawnLocation());
        else player.getWorld().getSpawnLocation();

        player.sendMessage(Utils.color("&aTeleported to Spawn"));
    }
}
