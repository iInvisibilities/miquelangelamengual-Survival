package es.hulk.survival.command.admin;

import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 17/04/2022 16:12
 * Project: Survival
 * Class: InvseeCommand
 */

public class InvseeCommand extends BaseCommand {

    @Command(name = "invsee", aliases = {"inv"}, permission = "survival.admin.invsee", inGameOnly = true)

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage("§cUso: /invsee <jugador>");
            return;
        }

        Player target = command.getPlayer().getServer().getPlayer(args[0]);

        if (target == null) {
            player.sendMessage("§cEl jugador no está online.");
        }

        assert target != null;
        player.openInventory(target.getInventory());
    }
}
