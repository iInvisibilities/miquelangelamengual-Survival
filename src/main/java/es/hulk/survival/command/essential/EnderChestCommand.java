package es.hulk.survival.command.essential;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class EnderChestCommand extends BaseCommand {

    @Command(name = "enderchest", aliases = "ec")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (player.getStatistic(Statistic.PLAY_ONE_MINUTE) >= 1080000) {
            player.openInventory(player.getEnderChest());
        } else {
            player.sendMessage(Utils.color("&cNoup"));
        }
    }
}
