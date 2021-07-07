package es.hulk.survival.managers.rank.impl;

import es.hulk.survival.managers.rank.Rank;
import org.bukkit.OfflinePlayer;

public class Default implements Rank {

    @Override
    public String getName(OfflinePlayer offlinePlayer) {
        return "";
    }

    @Override
    public String getPrefix(OfflinePlayer offlinePlayer) {
        return "";
    }

    @Override
    public String getSuffix(OfflinePlayer offlinePlayer) {
        return "";
    }

    @Override
    public String getDisplayName(OfflinePlayer offlinePlayer) {
        return "";
    }
}
