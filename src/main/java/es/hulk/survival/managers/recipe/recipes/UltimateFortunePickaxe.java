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

public class UltimateFortunePickaxe {

    public static void recipe() {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&aFortune Pickaxe"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.MENDING, 2);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 50);
        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 8);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 4);

        NamespacedKey key = new NamespacedKey(Survival.get(), "fortune_ultimate_pickaxe");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("LLL", "LNL", "LLL");
        recipe.setIngredient('L', Material.LAPIS_BLOCK);
        recipe.setIngredient('N', Material.NETHERITE_PICKAXE);

        Bukkit.addRecipe(recipe);
    }

}
