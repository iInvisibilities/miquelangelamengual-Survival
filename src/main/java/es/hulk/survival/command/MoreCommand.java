package es.hulk.survival.command;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class MoreCommand extends BaseCommand {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @Command(name = "more", permission = "survival.command.more")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        int amount = player.getInventory().getItemInMainHand().getAmount();

        if (args.length == 0) {
            player.getInventory().getItemInMainHand().setAmount(64);
            player.sendMessage(Utils.color(mainConfig.getString("MORE-COMMAND")));
        }
        if (args.length > 0) {
            if (Integer.parseInt(args[0]) <= amount) {
                player.sendMessage(Utils.color("&cYou have more amount for this item"));
                return;
            }
            player.getInventory().getItemInMainHand().setAmount(Integer.parseInt(args[0]));
            player.sendMessage(Utils.color(mainConfig.getString("MORE-COMMAND-AMOUNT").replaceAll("<amount>", args[0])));
        }
    }
}
