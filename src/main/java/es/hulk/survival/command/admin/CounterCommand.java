package es.hulk.survival.command.admin;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 14/10/2021 10:59
 * Project: Survival
 * Class: CounterCommand
 */

public class CounterCommand extends BaseCommand {

    @Command(name = "counter", permission = "survival.command.counter")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        Survival.get().setCounter(36);
        player.sendMessage(Utils.color(Utils.getPREFIX() + "&eLoaded &a" + Survival.get().getCounter() + " &ecommands"));
    }
}
