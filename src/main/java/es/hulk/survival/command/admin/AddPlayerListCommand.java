package es.hulk.survival.command.admin;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.SavePlayers;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.rmi.CORBA.Util;

public class AddPlayerListCommand extends BaseCommand {

    private final Survival plugin = Survival.get();

    @Command(name = "addplayer", permission = "survival.command.addplayer")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        plugin.setCounter(36);

        if (args.length == 0) {
            player.sendMessage(Utils.color("&cYou need to add a player to the list"));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(Utils.color("&cPlayer not found"));
            }

            assert target != null;
            SavePlayers.savePlayerIds(target);
            player.sendMessage("Hello :)");
        }
    }
}
