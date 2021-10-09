package es.hulk.survival.managers.recipe.smithingtable;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;

public class NameTag {

    public static void load() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG);

        RecipeChoice choice1 = new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_SIGN));
        RecipeChoice choice2 = new RecipeChoice.ExactChoice(new ItemStack(Material.STRING));
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Survival.get(),"nametag_craft"), itemStack, choice1, choice2);

        Bukkit.addRecipe(recipe);
    }
}
