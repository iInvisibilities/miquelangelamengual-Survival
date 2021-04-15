package es.hulk.survival.command;

import es.hulk.survival.Survival;
import es.hulk.survival.listeners.ServerListener;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;
import org.bukkit.event.server.ServerListPingEvent;

public class SetSlotsCommand extends BaseCommand {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @Command(name = "setslots", permission = "survival.command.setslots")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        mainConfig.getConfiguration().set(String.valueOf(mainConfig.getInt("SET-SLOTS")), args[0]);
    }
}
