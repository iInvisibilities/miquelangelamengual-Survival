package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class GolemsListener implements Listener {

    private FileConfig mainConfig = Survival.get().getMainConfig();
    private final int MAX_DROPS = 30;
    private final int MIN_DROPS = 1;

    @EventHandler
    public void onGolemDie(EntityDeathEvent event) {
        if (!mainConfig.getBoolean("ENTITIES.POPPY-DROP")) {
            if (event.getEntity().getType() == EntityType.IRON_GOLEM) {
                event.getDrops().removeIf(is -> is.getType() == Material.POPPY);
            }
        }
        if (mainConfig.getBoolean("ENTITIES.GUNPOWDER-BOOST")) {
            if (event.getEntity().getType() == EntityType.CREEPER) {
                int r = (int) (Math.random() * (MAX_DROPS - MIN_DROPS)) + MIN_DROPS;
                event.getDrops().add(new ItemStack(Material.GUNPOWDER, r));
            }
        }
    }
}
