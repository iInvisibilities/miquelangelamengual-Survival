package es.hulk.survival.command.admin;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GetPlayerInformationCommand extends BaseCommand {

    @Command(name = "playerinfo", permission = "survival.comand.playerinfo")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(Utils.color("&cUsage: /playerinfo <player>"));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(Utils.color(Utils.getPREFIX() + "&cEl Jugador " + args[0] + " no se ha encontrado."));
            }

            String fullip = String.valueOf(target.getAddress());
            String[] ip = fullip.split("/");
            String goodip = ip[1];

            player.sendMessage("");
            player.sendMessage(Utils.color("&aInformacion del Jugador"));
            player.sendMessage("");
            player.sendMessage(Utils.color("&eNombre&7: &f" + target.getDisplayName()));
            player.sendMessage(Utils.color("&eVersion&7: &f" + target.getServer().getBukkitVersion()));
            player.sendMessage(Utils.color("&ePing&7: &f" + Utils.getPing(target)));
            player.sendMessage(Utils.color("&eIP&7: &f" + goodip));
        }
    }
}
