package es.hulk.survival.utils;

import es.hulk.survival.Survival;
import org.bukkit.entity.Player;

public class SavePlayers {

    private static final Survival plugin = Survival.get();
    private static final FileConfig dataConfig = Survival.get().getDataConfig();

    public static void savePlayerIds(Player target) {
        plugin.getPlayersIds().add(target.getUniqueId());
        dataConfig.getConfiguration().set("PLAYERS_UUIDS", plugin.getPlayersIds());
        dataConfig.save();
    }

}
