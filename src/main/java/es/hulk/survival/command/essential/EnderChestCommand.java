package es.hulk.survival.command.essential;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class EnderChestCommand extends BaseCommand {

    @Command(name = "enderchest", aliases = "ec")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        
        if (player.getStatistic(Statistic.PLAY_ONE_MINUTE) >= 1080000) {
            if (args.length == 0) {
                player.openInventory(player.getEnderChest());
            }

            if (args.length > 0) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {
                    player.openInventory(player.getEnderChest());
                }

                if (player.hasPermission("survival.command.enderchest")) {
                    player.openInventory(target.getEnderChest());
                    return;
                }

                player.openInventory(player.getEnderChest());
            }
        } else {
            player.sendMessage(Utils.color(Utils.PREFIX + "&cNecesitas minimo 15h dentro del servidor &7(Para poder ver el tiempo usa /playtime)"));
        }
    }
}
