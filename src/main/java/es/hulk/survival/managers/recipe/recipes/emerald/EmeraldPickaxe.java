package es.hulk.survival.managers.recipe.recipes.emerald;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class EmeraldPickaxe {

    private static final Survival plugin = Survival.get();

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(Utils.color("&aEmerald Pickaxe"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 20);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 12);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 6);

        NamespacedKey key = new NamespacedKey(plugin, "emerald_block_pickaxe");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape("DDD", " I ", " I ");
        recipe.setIngredient('D', Material.EMERALD_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
