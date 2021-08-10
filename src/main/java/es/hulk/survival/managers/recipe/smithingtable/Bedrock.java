package es.hulk.survival.managers.recipe.smithingtable;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;

public class Bedrock {

    public static void recipe() {
        RecipeChoice choice = new RecipeChoice.ExactChoice(new ItemStack(Material.OBSIDIAN, 64));
        RecipeChoice choice1 = new RecipeChoice.ExactChoice(new ItemStack(Material.NETHERITE_BLOCK, 64));

        ItemStack result = new ItemStack(Material.BEDROCK);

        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Survival.get(),"crafteable_bedrock"), result, choice, choice1);
        Bukkit.addRecipe(recipe);
    }

}
