package es.hulk.survival;

import dev.hely.tab.api.Tab;
import es.hulk.survival.command.HelpCommand;
import es.hulk.survival.command.SurvivalCommand;
import es.hulk.survival.command.admin.*;
import es.hulk.survival.command.essential.*;
import es.hulk.survival.command.gamemode.GamemodeCommand;
import es.hulk.survival.command.essential.KillCommand;
import es.hulk.survival.command.location.LocationCommand;
import es.hulk.survival.command.SettingsCommand;
import es.hulk.survival.command.spawn.SetSpawnCommand;
import es.hulk.survival.command.spawn.SpawnCommand;
import es.hulk.survival.command.teleport.TeleportAllCommand;
import es.hulk.survival.command.teleport.TeleportCommand;
import es.hulk.survival.command.teleport.TeleportCoordsCommand;
import es.hulk.survival.command.teleport.TeleportHereCommand;
import es.hulk.survival.listeners.*;
import es.hulk.survival.managers.SpawnManager;
import es.hulk.survival.managers.menu.settings.SettingsManager;
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
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

@Setter
@Getter
public class Survival extends JavaPlugin {

    private FileConfig mainConfig;
    private FileConfig locationsConfig;
    private FileConfig spawnConfig;
    private FileConfig messagesConfig;
    private FileConfig menuConfig;
    private FileConfig serverConfig;

    private SpawnManager spawnManager;
    private Scoreboard scoreboard;
    private WarpManager warpManager;
    private RankManager rankManager;
    private CommandManager commandManager;
    private RecipeManager recipeManager;
    private SettingsManager settingsManager;
    private TPSUtil tpsUtil;

    private boolean PlaceholderAPI;

    @Override
    public void onEnable() {
        loadConfigs();
        loadManagers();
        getWarpManager().loadWarps();
        getRankManager().loadRank();
        getRecipeManager().load();
        setGamerule();

        Utils.sendConsole("");
        Utils.sendConsole("&aSurvival - 1.17");
        Utils.sendConsole("");
        Utils.sendConsole("Author: Hulk");
        Utils.sendConsole("Version: 1.17 - " + Survival.get().getDescription().getVersion());
        Utils.sendConsole("Rank System&7: &f" + getRankManager().getRankSystem());
        Utils.sendConsole("");

        this.getSettingsManager().load();

        loadScoreboard();
        loadListeners();
        loadCommands();
    }

    @Override
    public void onDisable() {
        warpManager.saveWarps();
    }

    public void loadManagers() {
        this.recipeManager = new RecipeManager();
        this.spawnManager = new SpawnManager();
        this.warpManager = new WarpManager(this);
        this.rankManager = new RankManager(this);
        this.commandManager = new CommandManager(this);
        this.settingsManager = new SettingsManager();
        this.tpsUtil = new TPSUtil(this);
        Utils.sendConsole("&8[&aSurvival&8] &eManagers loaded");
    }

    public void loadConfigs() {
        this.locationsConfig = new FileConfig(this, "locations.yml");
        this.mainConfig = new FileConfig(this, "settings.yml");
        this.spawnConfig = new FileConfig(this, "spawn.yml");
        this.messagesConfig = new FileConfig(this, "messages.yml");
        this.menuConfig = new FileConfig(this, "menu.yml");
        Utils.sendConsole("&8[&aSurvival&8] &eConfigs loaded");
    }


    public void loadScoreboard() {
        if (mainConfig.getBoolean("BOOLEANS.SCOREBOARD")) {
            this.scoreboard = new Scoreboard(this, new ScoreboardProvider());
            scoreboard.setTicks(2);
            Utils.sendConsole("&8[&aSurvival&8] &eScoreboard Enabled");
        } else {
            Utils.sendConsole("&8[&aSurvival&8] &cScoreboard Disabled");
        }

        if (mainConfig.getBoolean("BOOLEANS.TAB")) {
            new Tab(this, new TablistProvider());
            Utils.sendConsole("&8[&aSurvival&8] &eTablist Enabled");
        } else {
            Utils.sendConsole("&8[&aSurvival&8] &cTablist Disabled");
        }
    }

    public void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new EntityListener(), this);
        //pm.registerEvents(new BedListener(), this);
        pm.registerEvents(new ButtonListener(), this);
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
        Utils.sendConsole("&8[&aSurvival&8] &eCommands Registered");
    }


    public void setGamerule() {
        Objects.requireNonNull(Bukkit.getWorld("world")).setGameRule(GameRule.KEEP_INVENTORY, true);
        Objects.requireNonNull(Bukkit.getWorld("world")).setDifficulty(Difficulty.HARD);
        Objects.requireNonNull(Bukkit.getWorld("world_nether")).setGameRule(GameRule.KEEP_INVENTORY, true);
        Objects.requireNonNull(Bukkit.getWorld("world_nether")).setDifficulty(Difficulty.HARD);
        Objects.requireNonNull(Bukkit.getWorld("world_the_end")).setGameRule(GameRule.KEEP_INVENTORY, true);
        Objects.requireNonNull(Bukkit.getWorld("world_the_end")).setDifficulty(Difficulty.HARD);

        Utils.sendConsole("&8[&aSurvival&8] &eGamerule Updated");
    }

    public static Survival get() {
        return getPlugin(Survival.class);
    }
}
