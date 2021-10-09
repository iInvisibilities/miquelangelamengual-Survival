package es.hulk.survival.managers.recipe.recipes;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class UnbreakableSword {

    public static void recipe() {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&aUnbreakable Sword"));
        meta.setUnbreakable(true);

        pickaxe.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(Survival.get(), "unbreakable_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("NNN", "NPN", "NNN");
        recipe.setIngredient('N', Material.OBSIDIAN);
        recipe.setIngredient('P', Material.DIAMOND_SWORD);

        Bukkit.addRecipe(recipe);
    }

}
