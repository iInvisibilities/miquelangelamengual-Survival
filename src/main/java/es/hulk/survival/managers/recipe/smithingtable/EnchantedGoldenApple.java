package es.hulk.survival.managers.recipe.smithingtable;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;

public class EnchantedGoldenApple {

    public static void recipe() {
        RecipeChoice choice = new RecipeChoice.ExactChoice(new ItemStack(Material.GOLDEN_APPLE));
        RecipeChoice choice1 = new RecipeChoice.ExactChoice(new ItemStack(Material.DIAMOND_BLOCK));

        ItemStack result = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);

        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Survival.get(),"old_notch_apple"), result, choice, choice1);
        Bukkit.addRecipe(recipe);
    }

}
