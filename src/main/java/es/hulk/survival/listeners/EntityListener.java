package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.TimeUtil;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.counter.CounterHelper;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftEnderDragon;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityListener implements Listener {

    private FileConfig mainConfig = Survival.get().getMainConfig();

    @EventHandler
    public void onEntityDie(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        Random random = new Random();

        if (!mainConfig.getBoolean("ENTITIES.POPPY-DROP")) {
            if (event.getEntity().getType() == EntityType.IRON_GOLEM) {
                event.getDrops().removeIf(is -> is.getType() == Material.POPPY);
            }
        }

        if (mainConfig.getBoolean("ENTITIES.GUNPOWDER-BOOST")) {
            if (event.getEntity().getType() == EntityType.CREEPER) {
                event.getDrops().add(new ItemStack(Material.GUNPOWDER, random.nextInt(30)));

                if (event.getEntity() instanceof Player) {
                    if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                        event.getDrops().add(new ItemStack(Material.TNT));
                    }
                }
            }
        }

        if (mainConfig.getBoolean("ENTITIES.GHAST-THEAR-BOOST")) {
            if (event.getEntity().getType() == EntityType.GHAST) {

                event.getDrops().add(new ItemStack(Material.GHAST_TEAR, random.nextInt(20)));

                if (event.getEntity() instanceof Player) {
                    if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                        event.getDrops().add(new ItemStack(Material.NETHER_STAR, random.nextInt(2)));
                    }
                }
            }

            if (mainConfig.getBoolean("ENTITIES.CAT-BOOST")) {
                if (event.getEntity().getType() == EntityType.CAT) {
                    event.getDrops().add(new ItemStack(Material.MUTTON, random.nextInt(6)));
                    event.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(6)));
                }
            }

            if (mainConfig.getBoolean("ENTITIES.BEE-BOOST")) {
                if (event.getEntity().getType() == EntityType.BEE) {
                    event.getDrops().add(new ItemStack(Material.MUTTON, random.nextInt(6)));
                    event.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(6)));

                    if (event.getEntity() instanceof Player) {
                        if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) >= 3) {
                            event.getDrops().add(new ItemStack(Material.HONEY_BLOCK));
                        }
                    }
                }
            }
        }
    }

    public void checkEntityDeath(EntityDeathEvent event) {
        if (Survival.get().isSpeedRun()) {
            if (event.getEntity() instanceof CraftEnderDragon) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    online.sendTitle(Utils.color("&c&lEL ENDERDRAGON HA MUERTO"), Utils.color("&aHas necesitado &e" + TimeUtil.convert(CounterHelper.getTimer().getSeconds()) + " &apara matarlo"), 0, 20, 20);
                }
            }
        }
    }

    @EventHandler
    public void entityExplode(EntityExplodeEvent event) {
        if (event.getEntity().getType() == EntityType.CREEPER) {
            event.setCancelled(true);
            return;
        }
        event.setCancelled(false);
    }
}
