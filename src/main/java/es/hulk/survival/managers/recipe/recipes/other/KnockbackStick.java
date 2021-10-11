package es.hulk.survival.managers.recipe.recipes.other;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class KnockbackStick {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.STICK);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&aKnockback Stick"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.KNOCKBACK, 100);

        NamespacedKey key = new NamespacedKey(Survival.get(), "knockback_stick");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("OOO", "OIO", "OOO");
        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
