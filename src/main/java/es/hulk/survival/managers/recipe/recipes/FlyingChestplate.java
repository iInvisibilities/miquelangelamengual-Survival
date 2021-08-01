package es.hulk.survival.managers.recipe.recipes;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class FlyingChestplate {

    private static final Survival plugin = Survival.get();
    private static List<String> lore;

    public static void flyingChestplate() {

        lore.add(Utils.color("&aFly"));

        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();

        meta.setLore(lore);
        meta.setDisplayName(Utils.color("&aElytra + Chestplate"));
        meta.setUnbreakable(true);

        item.addUnsafeEnchantment(Enchantment.DURABILITY, 20);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);

        NamespacedKey key = new NamespacedKey(plugin, "flying_chestplate");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("DDD", "DID", "DDD");
        recipe.setIngredient('D', Material.IRON_BLOCK);
        recipe.setIngredient('I', Material.ELYTRA);

        Bukkit.addRecipe(recipe);
    }

}
