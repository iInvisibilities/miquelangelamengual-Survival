package es.hulk.survival.rank;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.OfflinePlayer;

public class LuckPermsAPI {

    private static final LuckPerms luckPerms = LuckPermsProvider.get();


    public static String getName(OfflinePlayer offlinePlayer) {
        User user = luckPerms.getUserManager().getUser(offlinePlayer.getUniqueId());
        return user.getPrimaryGroup();
    }

    public static String getPrefix(OfflinePlayer offlinePlayer) {
        User user = luckPerms.getUserManager().getUser(offlinePlayer.getUniqueId());
        return user.getCachedData().getMetaData().getPrefix();
    }

    public static String getSuffix(OfflinePlayer offlinePlayer) {
        User user = luckPerms.getUserManager().getUser(offlinePlayer.getUniqueId());
        return user.getCachedData().getMetaData().getSuffix();
    }

    public static String getDisplayName(OfflinePlayer offlinePlayer) {
        User user = luckPerms.getUserManager().getUser(offlinePlayer.getUniqueId());
        return luckPerms.getGroupManager().getGroup(user.getPrimaryGroup()).getDisplayName();
    }
}
