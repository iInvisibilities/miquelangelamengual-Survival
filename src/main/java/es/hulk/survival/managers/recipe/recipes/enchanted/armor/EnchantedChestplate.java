package es.hulk.survival.managers.recipe.recipes.enchanted.armor;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantedChestplate {

    public static void recipe() {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Utils.color("&aEnchanted Chestplate"));
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 20);
        item.addUnsafeEnchantment(Enchantment.MENDING, 1);
        item.addUnsafeEnchantment(Enchantment.OXYGEN, 20);
        item.addUnsafeEnchantment(Enchantment.WATER_WORKER, 10);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 30);

        NamespacedKey key = new NamespacedKey(Survival.get(), "DIAMOND_BLOCK_CHESTPLATE");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("D D", "DDD", "DDD");
        recipe.setIngredient('D', Material.DIAMOND_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
