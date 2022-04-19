package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayTimeCommand extends BaseCommand {

    @Command(name = "playtime")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        Survival.get().setCounter(17);

        if (args.length == 0) {
            player.sendMessage(Utils.color(Utils.getPREFIX() + "&aHas jugado un total de &e" + PlayerUtils.getPlayTime(player) + " &adentro del Servidor."));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(Utils.color(Utils.getPREFIX() + "&cEl jugador &4" + target.getName() + " &cno se ha encontrado."));
                return;
            }

            player.sendMessage(Utils.color(Utils.getPREFIX() + "&aEl Jugador &e" + target.getDisplayName() + " &aha jugado un total de &e" + PlayerUtils.getPlayTime(target) + " &adentro del Servidor."));
        }
    }
}
