package es.hulk.survival.managers.rank;

import es.hulk.survival.managers.rank.impl.Default;
import es.hulk.survival.managers.rank.impl.LuckPermsAPI;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

@Getter
@Setter
public class RankManager {

    @Getter
    private static RankManager instance;
    private Plugin plugin;
    private String rankSystem;
    private Rank rank;


    public RankManager(Plugin plugin) {
        instance = this;
        this.plugin = plugin;
    }

    public void loadRank() {
        if (Bukkit.getPluginManager().getPlugin("LuckPerms") != null) {
            this.setRank(new LuckPermsAPI());
            this.setRankSystem("LuckPerms");
        } else {
            this.setRank(new Default());
            this.setRankSystem("None");
        }
    }
}
