package es.hulk.survival.managers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public class RecipeManager {

    private Survival plugin;

    public void customExperienceBottle() {
        ItemStack exp = new ItemStack(Material.EXPERIENCE_BOTTLE);

        ShapedRecipe customExp = new ShapedRecipe(exp);
        customExp.shape("LLL", "LEL", "LLL");
        customExp.setIngredient('L', Material.LAPIS_LAZULI);
        customExp.setIngredient('E', Material.EMERALD);

        Bukkit.addRecipe(customExp);
    }

    public void customSword() {
        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta swordMeta = sword.getItemMeta();

        swordMeta.setDisplayName(Utils.color("&aUnbreakable Diamond Sword"));
        swordMeta.setUnbreakable(true);

        sword.setItemMeta(swordMeta);

        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 20);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 10);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 10);

        sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 20);
        sword.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 10);
        sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);

        ShapedRecipe swordRecipe = new ShapedRecipe(sword);

        swordRecipe.shape("DDD", "DED", "DDD");
        swordRecipe.setIngredient('D', Material.ELYTRA);
        swordRecipe.setIngredient('E', Material.NETHERITE_SWORD);

        Bukkit.addRecipe(swordRecipe);
    }

    public void enchantedElytra() {
        ItemStack item = new ItemStack(Material.ELYTRA);
        ItemMeta meta = item.getItemMeta();

        meta.setUnbreakable(true);
        meta.setDisplayName(Utils.color("&aUnbreakable God Elytra"));

        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("NNN", "NEN", "NNN");
        recipe.setIngredient('N', Material.NETHERITE_BLOCK);
        recipe.setIngredient('E', Material.ELYTRA);

        Bukkit.addRecipe(recipe);
    }

    public void loadRecipes() {
        customExperienceBottle();
        customSword();
        enchantedElytra();
    }

}
