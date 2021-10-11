package es.hulk.survival.managers.recipe.recipes.gold.armor;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Hulk
 * at 09/10/2021 23:21
 * Project: Survival
 * Class: IronLeggins
 */

public class GoldLeggings {

    public static void load() {
        ItemStack item = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Utils.color("&6Golden Leggings"));
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 2);

        NamespacedKey key = new NamespacedKey(Survival.get(), "GOLD_BLOCK_LEGGINGS");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("DDD", "D D", "D D");
        recipe.setIngredient('D', Material.GOLD_BLOCK);

        Bukkit.addRecipe(recipe);
    }
}
