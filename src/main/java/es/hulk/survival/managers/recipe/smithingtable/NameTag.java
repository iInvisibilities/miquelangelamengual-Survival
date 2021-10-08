package es.hulk.survival.managers.recipe.smithingtable;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;

public class NameTag {

    public static void recipe() {
        RecipeChoice choice = new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_SIGN));
        RecipeChoice choice1 = new RecipeChoice.ExactChoice(new ItemStack(Material.STRING));

        ItemStack result = new ItemStack(Material.NAME_TAG);

        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Survival.get(),"nametag_craft"), result, choice, choice1);
        Bukkit.addRecipe(recipe);
    }

}
