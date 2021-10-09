package es.hulk.survival.managers.recipe.smithingtable;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;

public class EnchantedGoldenApple {

    public static void load() {
        ItemStack itemStack = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);

        RecipeChoice choice1 = new RecipeChoice.ExactChoice(new ItemStack(Material.GOLDEN_APPLE));
        RecipeChoice choice2 = new RecipeChoice.ExactChoice(new ItemStack(Material.DIAMOND_BLOCK));
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Survival.get(),"enchanted_golden_apple"), itemStack, choice1, choice2);

        Bukkit.addRecipe(recipe);
    }
}
