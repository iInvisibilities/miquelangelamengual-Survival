package es.hulk.survival.command.admin;

import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 19/04/2022 12:33
 * Project: Survival
 * Class: TPWorldCommand
 */

public class TPWorldCommand extends BaseCommand {

    @Command(name = "tpworld", aliases = {"tpw"}, permission = "survival.admin.tpworld")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        World world = Bukkit.getWorld(args[0]);

        if (world == null) {
            player.sendMessage("§cWorld not found");
            return;
        }

        player.teleport(new Location(world, world.getSpawnLocation().getBlockX(), world.getSpawnLocation().getBlockY(), world.getSpawnLocation().getBlockZ()));
    }
}
