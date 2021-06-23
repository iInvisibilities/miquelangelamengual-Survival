package es.hulk.survival;

import es.hulk.survival.command.*;
import es.hulk.survival.listeners.ChatListener;
import es.hulk.survival.listeners.GolemsListener;
import es.hulk.survival.listeners.JoinListener;
import es.hulk.survival.listeners.QuitListener;
import es.hulk.survival.providers.ScoreboardProvider;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.CommandManager;
import es.hulk.survival.utils.scoreboard.Scoreboard;
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
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Utils.sendConsole("");
            Utils.sendConsole("&aSurvival - 1.16.5");
            Utils.sendConsole("");
            Utils.sendConsole("Author: Hulk");
            Utils.sendConsole("Version: 1.16.5 - " + Survival.get().getDescription().getVersion());
            Utils.sendConsole("");
            loadConfigs();
            loadScoreboard();
            loadListeners();
            loadCommands();
        } else {
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
    }

    public void loadConfigs() {
        this.scoreboardConfig = new FileConfig(this, "scoreboard.yml");
        this.mainConfig = new FileConfig(this, "config.yml");
        Utils.sendConsole("&8[&aSurvival&8] &eConfigs loaded");
    }


    public void loadScoreboard() {
        if (scoreboardConfig.getBoolean("SCOREBOARD.ENABLED")) {
            this.scoreboard = new Scoreboard(this, new ScoreboardProvider());
            scoreboard.setTicks(2);
            Utils.sendConsole("&8[&aSurvival&8] &eScoreboard Enabled");
        } else {
            Utils.sendConsole("&8[&aSurvival&8] &cScoreboard Disabled");
        }
    }

    public void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        commandManager = new CommandManager(this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new GolemsListener(), this);
        Utils.sendConsole("&8[&aSurvival&8] &eListeners Registered");
    }

    public void loadCommands() {
        new ReloadCommand();
        new CamaCoordCommand();
        new CoordsCommand();
        new MoreCommand();
        new SurvivalCommand();
        Utils.sendConsole("&8[&aSurvival&8] &eCommands Registered");
    }

    public static Survival get() {
        return getPlugin(Survival.class);
    }
}
