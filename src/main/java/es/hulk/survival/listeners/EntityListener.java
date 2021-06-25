package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityListener implements Listener {

    private FileConfig mainConfig = Survival.get().getMainConfig();
    private final String PATH = "ENTITIES.";

    @EventHandler
    public void onEntityDie(EntityDeathEvent event) {
        if (!mainConfig.getBoolean(PATH + "POPPY-DROP")) {
            if (event.getEntity().getType() == EntityType.IRON_GOLEM) {
                event.getDrops().removeIf(is -> is.getType() == Material.POPPY);
            }
        }

        if (mainConfig.getBoolean(PATH + "GUNPOWDERR-BOOST")) {
            if (event.getEntity().getType() == EntityType.CREEPER) {
                int RANDOMIZER = (int) (Math.random() * (50 - 1)) + 1;
                event.getDrops().add(new ItemStack(Material.GUNPOWDER, RANDOMIZER));
            }
        }

        if (mainConfig.getBoolean(PATH + "GHAST-THEAR-BOOST")) {
            if (event.getEntity().getType() == EntityType.GHAST) {
                int RANDOMIZER = (int) (Math.random() * (20 - 1)) + 1;
                event.getDrops().add(new ItemStack(Material.GHAST_TEAR, RANDOMIZER));
            }
        }
    }
}
