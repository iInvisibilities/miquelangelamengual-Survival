package es.hulk.survival.command.essential;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Locale;

public class ItemCommand extends BaseCommand {

    @Command(name = "giveitem", aliases = "i", permission = "survival.command.giveitem")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        int amount = 64;

        if (args.length == 0) {
            player.sendMessage(Utils.color("&cUsage: /item <name> <amount>"));
        }

        if (args.length > 0) {
            if (Material.valueOf(args[0].toUpperCase(Locale.ROOT)) != Material.getMaterial(args[0])) {
                player.sendMessage(Utils.color("&cItem " + args[0] + " doesnt exist."));
                return;
            }

            if (args[1].isEmpty()) {
                player.getInventory().addItem(new ItemStack(Material.valueOf(args[0].toUpperCase(Locale.ROOT)), amount));
                player.sendMessage(Utils.color("&aYou recived " + args[0] + " x" + amount));
                return;
            }
            player.getInventory().addItem(new ItemStack(Material.valueOf(args[0].toUpperCase(Locale.ROOT)), Integer.parseInt(args[1])));
            player.sendMessage(Utils.color("&aYou recived " + args[0] + " x" + args[1]));

        }
    }

}