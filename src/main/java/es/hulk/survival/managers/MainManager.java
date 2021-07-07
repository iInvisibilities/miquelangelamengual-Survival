package es.hulk.survival.managers;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.rank.RankManager;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.utils.command.CommandManager;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MainManager {

    private WarpManager warpManager;
    private RankManager rankManager;
    private CommandManager commandManager;
    private Survival plugin;

    public MainManager(WarpManager warpManager, RankManager rankManager, CommandManager commandManager) {
        this.warpManager = warpManager;
        this.rankManager = rankManager;
        this.commandManager = commandManager;
    }

    public void loadManagers() {
        warpManager = new WarpManager(plugin);
        rankManager = new RankManager(plugin);
        commandManager = new CommandManager(plugin);
    }

}
