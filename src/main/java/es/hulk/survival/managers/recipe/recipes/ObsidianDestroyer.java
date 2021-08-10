package es.hulk.survival.managers.recipe.recipes;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ObsidianDestroyer {

    private static final Survival plugin = Survival.get();

    public static void recipe() {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&aThe Obsidian Destroyer"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 50);
        pickaxe.addUnsafeEnchantment(Enchantment.MENDING, 1);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 30);

        NamespacedKey key = new NamespacedKey(plugin, "obsidian_destroyer");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("OOO", "ONO", "OOO");
        recipe.setIngredient('O', Material.NETHERITE_BLOCK);
        recipe.setIngredient('N', Material.DIAMOND_PICKAXE);

        Bukkit.addRecipe(recipe);
    }

}
