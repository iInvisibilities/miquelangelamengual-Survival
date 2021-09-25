package es.hulk.survival.managers.recipe.smithingtable;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.recipe.Recipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;

public class NameTag implements Recipe {

    @Override
    public ShapedRecipe recipe() {
        return null;
    }

    @Override
    public NamespacedKey key() {
        return null;
    }

    @Override
    public ItemStack item() {
        return new ItemStack(Material.NAME_TAG);
    }

    @Override
    public SmithingRecipe smithing() {
        return new SmithingRecipe(new NamespacedKey(Survival.get(),"nametag_craft"), item(), choice1(), choice2());
    }

    @Override
    public RecipeChoice choice1() {
        return new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_SIGN));
    }

    @Override
    public RecipeChoice choice2() {
        return new RecipeChoice.ExactChoice(new ItemStack(Material.STRING));
    }

    @Override
    public void load() {
        Bukkit.addRecipe(smithing());
    }

}
