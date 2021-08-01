package es.hulk.survival.managers.recipe.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;


public class CustomExperienceBottle {

    public static void customExperienceBottle() {
        ItemStack exp = new ItemStack(Material.EXPERIENCE_BOTTLE);

        ShapedRecipe customExp = new ShapedRecipe(exp);
        customExp.shape("LLL", "LEL", "LLL");
        customExp.setIngredient('L', Material.LAPIS_LAZULI);
        customExp.setIngredient('E', Material.EMERALD);

        Bukkit.addRecipe(customExp);
    }

}
