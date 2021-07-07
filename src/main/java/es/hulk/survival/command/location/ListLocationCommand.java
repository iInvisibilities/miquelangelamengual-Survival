package es.hulk.survival.command.location;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

import java.util.List;

public class ListLocationCommand extends BaseCommand {
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String aux = "";
        List<String> warpName = Survival.get().getConfig().getStringList("WARP.LIST");

        for (int i = 0; i < warpName.size(); i++) {
            aux = warpName.get(i);
        }
        player.sendMessage(aux);
    }
}
