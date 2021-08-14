package es.hulk.survival.managers.recipe.recipes;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Bow {

    public static void recipe() {
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&aBow"));
        pickaxe.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(Survival.get(), "bow_e");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("SSS", "IOI", " I ");
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
