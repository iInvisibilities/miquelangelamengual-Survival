package es.hulk.survival.command.gamemode.subcommands;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class SurvivalCommand extends BaseCommand {

    @Command(name = "survival", aliases = "s")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(Utils.color("&aYou are being putted into Survival Mode"));
    }

}
