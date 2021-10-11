package es.hulk.survival.managers.recipe.recipes.netherite.armor;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class NetheriteBoots {

    public static void load() {
        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Utils.color("&eUltimate Boots"));
        meta.setUnbreakable(true);
        item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 60);
        item.addUnsafeEnchantment(Enchantment.MENDING, 10);
        item.addUnsafeEnchantment(Enchantment.OXYGEN, 30);
        item.addUnsafeEnchantment(Enchantment.WATER_WORKER, 20);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 60);
        item.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 20);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 40);

        NamespacedKey key = new NamespacedKey(Survival.get(), "ULTIMATE_BOOTS");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("   ", "D D", "D D");
        recipe.setIngredient('D', Material.NETHERITE_BLOCK);

        Bukkit.addRecipe(recipe);
    }

}
