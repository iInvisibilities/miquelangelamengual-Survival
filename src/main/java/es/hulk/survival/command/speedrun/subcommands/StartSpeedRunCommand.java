package es.hulk.survival.command.speedrun.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.world.WorldManager;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.counter.CounterHelper;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

/**
 * Created by Hulk
 * at 17/04/2022 20:37
 * Project: Survival
 * Class: StartSpeedRunCommand
 */

public class StartSpeedRunCommand extends BaseCommand {

    @Getter private static WorldManager worldManager;
    @Getter private static ItemStack[] inventory;

    @Command(name = "speedrun.start", permission = "survival.speedrun.start", inGameOnly = true)

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (Survival.get().getSpeedRunners().isEmpty()) {
            player.sendMessage(Utils.color("&cThere are no speedrunners in the server."));
            return;
        }

        String speedrun = Survival.get().getSpeedRunners().get(0);
        Player speedrunPlayer = Bukkit.getPlayer(speedrun);

        if (speedrunPlayer == null) return;

        worldManager = new WorldManager(speedrun);
        worldManager.deleteWorlds();
        worldManager.createWorlds();
        speedrunPlayer.teleport(new Location(Bukkit.getWorld(worldManager.getPlayerWorldName()), 0, 70, 0));

        inventory = speedrunPlayer.getInventory().getContents();
        speedrunPlayer.getInventory().clear();
        Survival.get().setCounterEnabled(true);
        Survival.get().setSpeedRun(true);
        CounterHelper.startRunnable();
        Bukkit.broadcastMessage(Utils.color("&aEl Speedrun ha comenzado!"));
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.sendTitle(Utils.color("&a&lSPEEDRUN EMPEZADO"), Utils.color("&eEl Cronometro a empezado!"), 20, 30, 30);
        }
        player.sendMessage(Utils.color("&aEl Speedrun ha empezado."));
    }
}
