package es.hulk.survival.managers.recipe;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;

/**
 * Created by Hulk
 * at 25/09/2021 19:08
 * all credits reserved
 */

public interface Recipe {

    ShapedRecipe recipe();
    NamespacedKey key();
    ItemStack item();
    SmithingRecipe smithing();

    RecipeChoice choice1();
    RecipeChoice choice2();

    void load();



}
