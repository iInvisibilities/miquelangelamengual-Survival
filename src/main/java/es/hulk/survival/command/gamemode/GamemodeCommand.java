package es.hulk.survival.command.gamemode;

import es.hulk.survival.command.gamemode.subcommands.CameraCommand;
import es.hulk.survival.command.gamemode.subcommands.SurvivalCommand;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.GameMode;
import org.bukkit.Statistic;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand extends BaseCommand {

    public GamemodeCommand() {
        new CameraCommand();
        new SurvivalCommand();
    }

    @Command(name = "mode")
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender commandSender = command.getSender();
        String[] args = command.getArgs();
        Player player = command.getPlayer();

        if (player.getStatistic(Statistic.PLAY_ONE_MINUTE) >= 2160000) {
            if (args.length == 0) {
                getUsage(commandSender);
            }

            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("camera")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(Utils.color(Utils.getPREFIX() + "&aYou are being putted into Camera Mode"));
                    return;
                }

                if (args[0].equalsIgnoreCase("survival")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(Utils.color(Utils.getPREFIX() + "&aYou are being putted into Survival Mode"));
                    return;
                }

                getUsage(commandSender);

                if (args[0].isEmpty()) {
                    getUsage(commandSender);
                }
            }
        } else {
            player.sendMessage(Utils.color(Utils.getPREFIX() + "&cNecesitas minimo 30h dentro del servidor &7(Usa el comando /playtime para ver el tiempo que llevas jugado)"));
        }
    }

    public void getUsage(CommandSender commandSender) {
        commandSender.sendMessage(Utils.getLINE());
        commandSender.sendMessage(Utils.color("&e/mode <survivalm/camera> &7- &fits put you in the mode u want"));
        commandSender.sendMessage(Utils.color("&e/cameram &7- &fPuts the player into spectator mode (can use /cm)"));
        commandSender.sendMessage(Utils.color("&e/survivalm &7- &fPuts the player into survival mode (can use /sm)"));
        commandSender.sendMessage(Utils.getLINE());

    }

}
