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

public class UltimateBow {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.BOW);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&eUltimate Bow"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 80);
        pickaxe.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 50);
        pickaxe.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 50);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 30);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
        pickaxe.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 10);

        NamespacedKey key = new NamespacedKey(Survival.get(), "ultimate_bow");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("SSS", "MOM", "BBB");
        recipe.setIngredient('O', Material.BOW);
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('B', Material.NETHERITE_BLOCK);
        recipe.setIngredient('M', Material.OAK_LOG);

        Bukkit.addRecipe(recipe);
    }

}
