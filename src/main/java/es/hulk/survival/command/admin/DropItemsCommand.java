package es.hulk.survival.command.admin;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DropItemsCommand extends BaseCommand {

    @Command(name = "dropitems", permission = "survival.command.dropitems")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(Utils.color("&cUsage: /dropitems <player>"));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(Utils.color(Utils.getPREFIX() + "&cEl Jugador " + args[0] + " no esta en linea o no existe."));
                return;
            }

            for (ItemStack i : target.getInventory().getContents()) {
                if (i != null) {
                    target.getWorld().dropItemNaturally(target.getLocation(), i);
                    target.getInventory().remove(i);
                    target.getInventory().setArmorContents(null);
                    target.getInventory().getItemInOffHand().setAmount(0);
                }
            }

            player.sendMessage(Utils.color(Utils.getPREFIX() + "&aLos items del jugador &e" + target.getDisplayName() + " &ahan sido dropeados."));
        }
        Survival.get().setCounter(2);
    }
}
