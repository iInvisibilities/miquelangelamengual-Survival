package es.hulk.survival.managers.world;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 19/04/2022 12:02
 * Project: Survival
 * Class: WorldManager
 */

@Getter
public class WorldManager {

    private String playerWorldName, playerNetherWorldName, playerEndWorldName;
    private String playerName;
    private Player player;
    private final MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");

    public WorldManager(String speedRunner) {
        this.player = Bukkit.getPlayer(speedRunner);

        if (player == null) {
            System.out.println("There are no player online with this name: " + speedRunner);
            return;
        }

        this.playerWorldName = player.getName() + "_world";
        this.playerNetherWorldName = player.getName() + "_world_nether";
        this.playerEndWorldName = player.getName() + "_world_the_end";
    }

    public void deleteWorlds() {
        if (core == null) {
            System.out.println("There are no Multiverse-Core plugin installed, no per player world will be created on speedrunner world");
            return;
        }

        MVWorldManager worldManager = core.getMVWorldManager();
        worldManager.deleteWorld(playerWorldName);
        worldManager.deleteWorld(playerNetherWorldName);
        worldManager.deleteWorld(playerEndWorldName);
    }

    public void createWorlds() {
        if (core == null) {
            System.out.println("There are no Multiverse-Core plugin installed, no per player world will be created on speedrunner world");
            return;
        }

        MVWorldManager worldManager = core.getMVWorldManager();

        worldManager.addWorld(
                playerWorldName,
                World.Environment.NORMAL,
                null,
                WorldType.NORMAL,
                true,
                null
        );

        worldManager.addWorld(
                playerNetherWorldName,
                World.Environment.NETHER,
                null,
                WorldType.NORMAL,
                true,
                null
        );

        worldManager.addWorld(
                playerEndWorldName,
                World.Environment.THE_END,
                null,
                WorldType.NORMAL,
                true,
                null
        );
    }
}
