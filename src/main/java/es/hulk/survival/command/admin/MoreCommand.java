package es.hulk.survival.command.admin;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class MoreCommand extends BaseCommand {

    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();

    @Command(name = "more", permission = "survival.command.more")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        int amount = player.getInventory().getItemInMainHand().getAmount();

        if (args.length == 0) {
            player.getInventory().getItemInMainHand().setAmount(64);
            player.sendMessage(Utils.color(messagesConfig.getString("MORE_COMMAND.STACKED")));
        }
        if (args.length > 0) {
            if (Integer.parseInt(args[0]) <= amount) {
                player.sendMessage(Utils.color("&cYou have more amount for this item"));
                return;
            }
            player.getInventory().getItemInMainHand().setAmount(Integer.parseInt(args[0]));
            player.sendMessage(Utils.color(messagesConfig.getString("MORE_COMMAND.AMOUNT").replaceAll("<amount>", args[0])));
        }
        Survival.get().setCounter(6);
    }
}
