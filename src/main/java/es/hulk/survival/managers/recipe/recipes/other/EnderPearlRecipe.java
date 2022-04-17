package es.hulk.survival.managers.recipe.recipes.other;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
/**
 * Created by Hulk
 * at 17/04/2022 18:59
 * Project: Survival
 * Class: EnderPearlRecipe
 */

public class EnderPearlRecipe {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.ENDER_PEARL);

        NamespacedKey key = new NamespacedKey(Survival.get(), "CUSTOM_ENDER_PEARL");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("GGG", "PEP", "GGG");
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('P', Material.BLAZE_POWDER);
        recipe.setIngredient('E', Material.SPIDER_EYE);

        Bukkit.addRecipe(recipe);
    }
}

