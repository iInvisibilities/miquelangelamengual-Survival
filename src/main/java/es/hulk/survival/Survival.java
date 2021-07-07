package es.hulk.survival;

import es.hulk.survival.command.*;
import es.hulk.survival.listeners.*;
import es.hulk.survival.providers.ScoreboardProvider;
import es.hulk.survival.rank.Rank;
import es.hulk.survival.rank.RankManager;
import es.hulk.survival.rank.impl.LuckPermsAPI;
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
    private FileConfig commandsConfig;

    private RankManager rankManager;
    private Scoreboard scoreboard;
    private CommandManager commandManager;
    private LuckPermsAPI luckPermsAPI;

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            loadRanks();
            getRankManager().loadRank();

            Utils.sendConsole("");
            Utils.sendConsole("&aSurvival - 1.16.5");
            Utils.sendConsole("");
            Utils.sendConsole("Author: Hulk");
            Utils.sendConsole("Version: 1.16.5 - " + Survival.get().getDescription().getVersion());
            Utils.sendConsole("&eRank System&7: &f" + this.getRankManager().getRankSystem());
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

    public void loadRanks() {
        rankManager = new RankManager(this);
    }

    public void loadConfigs() {
        this.scoreboardConfig = new FileConfig(this, "scoreboard.yml");
        this.mainConfig = new FileConfig(this, "config.yml");
        this.commandsConfig = new FileConfig(this, "commands.yml");
        Utils.sendConsole("&8[&aSurvival&8] &eConfigs loaded");
    }


    public void loadScoreboard() {
        if (scoreboardConfig.getBoolean("SCOREBOARD.ENABLED")) {
            this.scoreboard = new Scoreboard(this, new ScoreboardProvider());
            scoreboard.setTicks(2);
            Utils.sendConsole("&8[&aSurvival&8] &eScoreboard Enabled");
            return;
        }
        Utils.sendConsole("&8[&aSurvival&8] &cScoreboard Disabled");
    }

    public void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        commandManager = new CommandManager(this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new EntityListener(), this);
        pm.registerEvents(new BedListener(), this);
        Utils.sendConsole("&8[&aSurvival&8] &eListeners Registered");
    }

    public void loadCommands() {
        new ReloadCommand();
        new SurvivalCommand();

        if (commandsConfig.getBoolean("TOGGLE-COMMANDS.CAMACOORDS")) {
            new CamaCoordCommand();
        }
        if (commandsConfig.getBoolean("TOGGLE-COMMANDS.COORDS")) {
            new CoordsCommand();
        }
        if (commandsConfig.getBoolean("TOGGLE-COMMANDS.MORE")) {
            new MoreCommand();
        }
        if (commandsConfig.getBoolean("TOGGLE-COMMANDS.FLY")) {
            new FlyCommand();
        }

        Utils.sendConsole("&8[&aSurvival&8] &eCommands Registered");
    }

    public static Survival get() {
        return getPlugin(Survival.class);
    }
}
