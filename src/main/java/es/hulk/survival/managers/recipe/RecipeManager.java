package es.hulk.survival.managers.recipe;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.recipe.recipes.*;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public class RecipeManager {

    private Survival plugin;

    public void enchantedElytra() {
        ItemStack item = new ItemStack(Material.ELYTRA);
        ItemMeta meta = item.getItemMeta();

        meta.setUnbreakable(true);
        meta.setDisplayName(Utils.color("&aUnbreakable God Elytra"));

        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("NNN", "NEN", "NNN");
        recipe.setIngredient('N', Material.NETHERITE_BLOCK);
        recipe.setIngredient('E', Material.ELYTRA);

        Bukkit.addRecipe(recipe);
    }

    public void loadRecipes() {
        EnchantedPickaxe.enchantedPickaxe();
        CustomExperienceBottle.customExperienceBottle();
        enchantedElytra();
    }

}
