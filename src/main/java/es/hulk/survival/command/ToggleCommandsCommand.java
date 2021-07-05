package es.hulk.survival.command;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class ToggleCommandsCommand extends BaseCommand {

    private FileConfig commandsConfig = Survival.get().getCommandsConfig();

    @Command(name = "commands", permission = "survival.command.togglecmd")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(Utils.color("&cUsage: /commands toggle <command> <true/false>"));
        }

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("toggle")) {
                if (args[1].equalsIgnoreCase("more") || args[1].equalsIgnoreCase("fly") || args[1].equalsIgnoreCase("coords") || args[1].equalsIgnoreCase("camacoords")) {
                    if (args[2].equalsIgnoreCase("true")) {
                        commandsConfig.getConfiguration().set("TOGGLE-COMMANDS." + args[1], "true");
                    }
                    if (args[2].equalsIgnoreCase("false")) {
                        commandsConfig.getConfiguration().set("TOGGLE-COMMANDS." + args[1], "false");
                    }
                }
            }
        }
    }
}
