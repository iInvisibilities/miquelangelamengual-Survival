package es.hulk.survival.command.essential;

import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SeedCommand extends BaseCommand {

    @Command(name = "semilla")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.sendMessage(String.valueOf(Bukkit.getWorlds().get(0).getSeed()));
    }
}
