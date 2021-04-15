package es.hulk.survival;

import es.hulk.survival.command.ReloadCommand;
import es.hulk.survival.command.RulesCommand;
import es.hulk.survival.listeners.ChatListener;
import es.hulk.survival.listeners.JoinListener;
import es.hulk.survival.listeners.ServerListener;
import es.hulk.survival.providers.ScoreboardProvider;
import es.hulk.survival.providers.TablistProvider;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.CommandManager;
import es.hulk.survival.utils.scoreboard.Scoreboard;
import io.github.nosequel.tab.shared.TabHandler;
import io.github.nosequel.tab.v1_16_r3.v1_16_R3TabAdapter;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Setter
@Getter
public final class Survival extends JavaPlugin {

    private FileConfig scoreboardConfig;
    private FileConfig mainConfig;

    private Scoreboard scoreboard;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        loadConfigs();
        loadScoreboard();
        loadListeners();
        loadTablist();
        loadCommands();
    }

    @Override
    public void onDisable() {}

    public void loadConfigs() {
        this.scoreboardConfig = new FileConfig(this, "scoreboard.yml");
        this.mainConfig = new FileConfig(this, "config.yml");
        Utils.sendConsole("&aFiles Loaded");
    }

    public void loadScoreboard() {
        if (mainConfig.getBoolean("BOOLEANS.SCOREBOARD")) {
            this.scoreboard = new Scoreboard(this, new ScoreboardProvider());
            scoreboard.setTicks(2);
            Utils.sendConsole("&aScoreboard Enabled");
        }
    }

    public void loadTablist() {
        if (mainConfig.getBoolean("BOOLEANS.TABLIST")) {
            new TabHandler(new v1_16_R3TabAdapter(), new TablistProvider(), this, 20L);
            Utils.sendConsole("&aTablist Enabled");
        }
    }

    public void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        this.commandManager = new CommandManager(this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new ServerListener(), this);
        Utils.sendConsole("&aListners Loaded");
    }

    public void loadCommands() {
        new ReloadCommand();
        new RulesCommand();
        Utils.sendConsole("&aCommands loaded");
    }

    public static Survival get() {
        return getPlugin(Survival.class);
    }
}
