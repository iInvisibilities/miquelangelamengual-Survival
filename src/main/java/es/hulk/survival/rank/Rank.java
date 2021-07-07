package es.hulk.survival.rank;

import org.bukkit.OfflinePlayer;

public interface Rank {

    public String getName(OfflinePlayer offlinePlayer);
    public String getPrefix(OfflinePlayer offlinePlayer);
    public String getSuffix(OfflinePlayer offlinePlayer);
    public String getDisplayName(OfflinePlayer offlinePlayer);


}
