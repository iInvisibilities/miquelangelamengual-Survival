package es.hulk.survival.managers.recipe.recipes.coal;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class CoalShovel {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.STONE_SHOVEL);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&7Coal Shovel"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        NamespacedKey key = new NamespacedKey(Survival.get(), "coal_block_shovel");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" D ", " I ", " I ");
        recipe.setIngredient('D', Material.COAL_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
