package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
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
        Survival.get().setCounter(18);
        String seed = String.valueOf(Bukkit.getWorlds().get(0).getSeed());

        player.sendMessage(Utils.color(Utils.getPREFIX() + "&aLa seed del juego es &e" + seed));
    }
}
