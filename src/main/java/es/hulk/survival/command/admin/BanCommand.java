package es.hulk.survival.command.admin;

import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.Arrays;

import static org.bukkit.BanList.Type;

public class BanCommand extends BaseCommand {

    @Command(name = "ban", permission = "survival.command.ban")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        String reason = Arrays.toString(Arrays.copyOfRange(args, 1, args.length))
                    .replaceAll(",", "")
                    .replace("[", "").replace("]", "");

        Player target = Bukkit.getPlayer(args[0]);
        assert target != null;
        if (reason == null) {
            reason = "Default Reason";
        }
        Bukkit.getBanList(Type.NAME).addBan(target.getName(), reason, null, player.getName());
    }
}
