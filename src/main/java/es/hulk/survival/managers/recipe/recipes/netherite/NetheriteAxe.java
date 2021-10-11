package es.hulk.survival.managers.recipe.recipes.netherite;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class NetheriteAxe {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&eUltimate Axe"));
        meta.setUnbreakable(true);
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.MENDING, 10);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 50);
        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 40);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 60);

        NamespacedKey key = new NamespacedKey(Survival.get(), "ULTIMATE_AXE");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" NN", " IN", " I ");
        recipe.setIngredient('N', Material.NETHERITE_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
