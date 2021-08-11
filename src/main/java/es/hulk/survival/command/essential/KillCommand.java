package es.hulk.survival.command.essential;

import es.hulk.survival.utils.UUIDs;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KillCommand extends BaseCommand {

    @Command(name = "mekill", aliases = "suicide")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.setHealth(0.0D);
        player.sendMessage(Utils.color("&aTe has muerto de cancer rata"));
        if (player.getUniqueId().equals(UUIDs.rafaUUID())) {
            Bukkit.broadcastMessage(Utils.color("&7[&aSurvival&7] &e" + player.getDisplayName() + " &ase ha suicidado. F en el chat por el hombre caido"));
            player.kickPlayer(Utils.color("Te has suicidado cabron"));
        }
    }
}
