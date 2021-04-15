package es.hulk.survival.command;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;

public class ReloadCommand extends BaseCommand {

    private final FileConfig mainConfig = Survival.get().getMainConfig();
    private final FileConfig scoreboardConfig = Survival.get().getScoreboardConfig();
    private final FileConfig tablistConfig = Survival.get().gxdetTablistConfig();

    @Command(name = "survival.reload", permission = "survival.command.reload")

    @Override
    public void onCommand(CommandArgs command) {
        this.mainConfig.reload();
        this.scoreboardConfig.reload();
        this.tablistConfig.reload();
        command.getPlayer().sendMessage(Utils.color(mainConfig.getString("FILE-RELOAD")));
    }
}
