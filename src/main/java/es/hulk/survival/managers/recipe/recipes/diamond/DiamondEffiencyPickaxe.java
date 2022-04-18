package es.hulk.survival.managers.recipe.recipes.diamond;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Hulk
 * at 18/04/2022 22:02
 * Project: Survival
 * Class: DiamondEffiencyPickaxe
 */

public class DiamondEffiencyPickaxe {

    private static final Survival plugin = Survival.get();

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&bDiamond Efficency Pickaxe"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 12);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 5);

        NamespacedKey key = new NamespacedKey(plugin, "diamond_effiency_block_pickaxe");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("DDD", " I ", " I ");
        recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }
}
