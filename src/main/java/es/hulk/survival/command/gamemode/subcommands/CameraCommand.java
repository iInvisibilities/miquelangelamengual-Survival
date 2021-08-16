package es.hulk.survival.command.gamemode.subcommands;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.GameMode;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class CameraCommand extends BaseCommand {

    @Command(name = "camera", aliases = "cm")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (player.getStatistic(Statistic.PLAY_ONE_MINUTE) >= 2160000) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(Utils.color("&aYou are being putted into Camera Mode"));
        } else {
            player.sendMessage(Utils.color(Utils.PREFIX + "&cNecesitas minimo 30h dentro del servidor &7(Usa el comando /playtime para ver el tiempo que llevas jugado)"));
        }
    }
}
