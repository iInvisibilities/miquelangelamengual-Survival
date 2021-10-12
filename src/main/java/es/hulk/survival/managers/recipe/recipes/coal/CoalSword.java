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

public class CoalSword {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&7Coal Sword"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        NamespacedKey key = new NamespacedKey(Survival.get(), "coal_block_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" D ", " D ", " I ");
        recipe.setIngredient('D', Material.COAL_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
