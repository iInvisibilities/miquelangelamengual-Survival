package es.hulk.survival.command.admin;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClearServerCommand extends BaseCommand {

    @Command(name = "clearserver", aliases = "defora")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.kickPlayer(Utils.color("&aEl servidor se ha limpiado correctamente"));
        }

        Survival.get().setCounter(1);
    }
}
