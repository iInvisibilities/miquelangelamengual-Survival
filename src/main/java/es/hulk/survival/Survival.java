package es.hulk.survival;

import es.hulk.survival.command.HelpCommand;
import es.hulk.survival.command.SurvivalCommand;
import es.hulk.survival.command.admin.*;
import es.hulk.survival.command.essential.*;
import es.hulk.survival.command.gamemode.GamemodeCommand;
import es.hulk.survival.command.essential.KillCommand;
import es.hulk.survival.command.location.LocationCommand;
import es.hulk.survival.command.SettingsCommand;
import es.hulk.survival.command.spawn.SetSpawnCommand;
import es.hulk.survival.command.spawn.SpawnChunksCoordsCommand;
import es.hulk.survival.command.spawn.SpawnCommand;
import es.hulk.survival.command.speedrun.SpeedRunCommand;
import es.hulk.survival.command.stats.SetStatsCommand;
import es.hulk.survival.command.stats.StatsCommand;
import es.hulk.survival.command.teleport.TeleportAllCommand;
import es.hulk.survival.command.teleport.TeleportCommand;
import es.hulk.survival.command.teleport.TeleportCoordsCommand;
import es.hulk.survival.command.teleport.TeleportHereCommand;
import es.hulk.survival.listeners.*;
import es.hulk.survival.managers.SpawnManager;
import es.hulk.survival.managers.rank.RankManager;
import es.hulk.survival.managers.recipe.RecipeManager;
import es.hulk.survival.managers.warp.WarpManager;
import es.hulk.survival.providers.ScoreboardProvider;
import es.hulk.survival.providers.TablistProvider;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.TPSUtil;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.CommandManager;
import es.hulk.survival.utils.menu.ButtonListener;
import es.hulk.survival.utils.scoreboard.Scoreboard;
import es.hulk.tablist.Omega;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Survival extends JavaPlugin {

    private FileConfig mainConfig;
    private FileConfig locationsConfig;
    private FileConfig spawnConfig;
    private FileConfig messagesConfig;
    private FileConfig serverConfig;

    private SpawnManager spawnManager;
    private Scoreboard scoreboard;
    private WarpManager warpManager;
    private RankManager rankManager;
    private CommandManager commandManager;
    private RecipeManager recipeManager;
    private TPSUtil tpsUtil;
    private Omega tablist;

    private int counter = 0;
    private boolean isPlaceholderAPI;

    private boolean isCounterEnabled;
    private boolean isSpeedRun;
    private boolean speedRunDeathCounter;
    private List<String> speedRunners = new ArrayList<>();

    @Override
    public void onEnable() {
        this.loadConfigs();
        this.loadManagers();
        this.getWarpManager().loadWarps();
        this.getRankManager().loadRank();
        this.scoreboardCounter();

        if (mainConfig.getBoolean("ENABLE_CUSTOM_RECIPES")) {
            getRecipeManager().load();
        }
        this.setGamerules();

        if (Bukkit.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            isPlaceholderAPI = true;
        }

        Utils.sendConsole(Utils.getLINE());
        Utils.sendConsole("");
        Utils.sendConsole("&aSurvival &e- &f" + getDescription().getVersion());
        Utils.sendConsole("");
        Utils.sendConsole("&aAuthor&7: &f" + getDescription().getAuthors());
        Utils.sendConsole("&aVersion&7: &f1.18.1");
        Utils.sendConsole("&aRank System&7: &f" + getRankManager().getRankSystem());
        Utils.sendConsole("");
        this.loadProviders();
        Utils.sendConsole(Utils.getLINE());
        this.loadListeners();
        this.loadCommands();
    }

    @Override
    public void onDisable() {
        warpManager.saveWarps();
        this.scoreboard.getBoards().clear();
        this.tablist.disable();
    }

    public void loadManagers() {
        this.recipeManager = new RecipeManager();
        this.spawnManager = new SpawnManager();
        this.warpManager = new WarpManager(this);
        this.rankManager = new RankManager(this);
        this.commandManager = new CommandManager(this);
        this.tpsUtil = new TPSUtil(this);
        Utils.sendConsole("&8[&aSurvival&8] &eManagers loaded");
    }

    public void loadConfigs() {
        this.locationsConfig = new FileConfig(this, "data/locations.yml");
        this.spawnConfig = new FileConfig(this, "data/spawn.yml");
        this.mainConfig = new FileConfig(this, "settings.yml");
        this.messagesConfig = new FileConfig(this, "messages.yml");
        Utils.sendConsole("&8[&aSurvival&8] &eConfigs loaded");
    }

    public void loadProviders() {
        if (mainConfig.getBoolean("BOOLEANS.SCOREBOARD")) {
            this.scoreboard = new Scoreboard(this, new ScoreboardProvider());
            scoreboard.setTicks(2);
        }

        if (mainConfig.getBoolean("BOOLEANS.TAB")) {
            tablist = new Omega(this, new TablistProvider());
        }
    }

    public void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new EntityListener(), this);
        pm.registerEvents(new BedListener(), this);
        pm.registerEvents(new ButtonListener(), this);
        pm.registerEvents(new CommandsListener(), this);
        pm.registerEvents(new DeathListener(), this);
        Utils.sendConsole("&8[&aSurvival&8] &eListeners Registered");
    }

    public void loadCommands() {
        new SurvivalCommand();
        new ItemCommand();
        new LocationCommand();
        new GamemodeCommand();
        new CamaCoordCommand();
        new CoordsCommand();
        new MoreCommand();
        new FlyCommand();
        new SpawnCommand();
        new SetSpawnCommand();
        new KillCommand();
        new PingCommand();
        new HealthCommand();
        new DiscordCommand();
        new PlayTimeCommand();
        new SetNameCommand();
        new BedTPCommand();
        new KillAllCommand();
        new EnderChestCommand();
        new TeleportCommand();
        new TeleportHereCommand();
        new TeleportAllCommand();
        new TeleportCoordsCommand();
        new ClearServerCommand();
        new HelpCommand();
        new SeedCommand();
        new SettingsCommand();
        new DropItemsCommand();
        new GetPlayerInformationCommand();
        new StatsCommand();
        new SetStatsCommand();
        new CounterCommand();
        new SpawnChunksCoordsCommand();
        new GiveExperienceCommand();
        new BanCommand();
        new SpeedRunCommand();
        new TPWorldCommand();
        new WorldInfoCommand();
        Utils.sendConsole("&8[&aSurvival&8] &eLoaded &a37 &ecommands");
    }

    public void setGamerules() {
        for (World world : Bukkit.getWorlds()) {
            world.setDifficulty(Difficulty.HARD);
            world.setGameRule(GameRule.KEEP_INVENTORY, true);
        }
        Utils.sendConsole("&8[&aSurvival&8] &eGamerule Updated");
    }

    private void scoreboardCounter() {
        this.isCounterEnabled = false;
        this.isSpeedRun = false;
    }

    public static Survival get() {
        return getPlugin(Survival.class);
    }
}
