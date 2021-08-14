package es.hulk.survival.managers.recipe;

import es.hulk.survival.managers.recipe.recipes.*;
import es.hulk.survival.managers.recipe.recipes.enchanted.EnchantedAxe;
import es.hulk.survival.managers.recipe.recipes.enchanted.EnchantedPickaxe;
import es.hulk.survival.managers.recipe.recipes.enchanted.EnchantedShovel;
import es.hulk.survival.managers.recipe.recipes.enchanted.EnchantedSword;
import es.hulk.survival.managers.recipe.recipes.enchanted.armor.EnchantedBoots;
import es.hulk.survival.managers.recipe.recipes.enchanted.armor.EnchantedChestplate;
import es.hulk.survival.managers.recipe.recipes.enchanted.armor.EnchantedHelmet;
import es.hulk.survival.managers.recipe.recipes.enchanted.armor.EnchantedLeggings;
import es.hulk.survival.managers.recipe.recipes.ultimate.*;
import es.hulk.survival.managers.recipe.recipes.ultimate.armor.UltimateBoots;
import es.hulk.survival.managers.recipe.recipes.ultimate.armor.UltimateChestplate;
import es.hulk.survival.managers.recipe.recipes.ultimate.armor.UltimateHelmet;
import es.hulk.survival.managers.recipe.recipes.ultimate.armor.UltimateLeggings;
import es.hulk.survival.managers.recipe.smithingtable.Bedrock;
import es.hulk.survival.managers.recipe.smithingtable.EnchantedGoldenApple;
import es.hulk.survival.managers.recipe.smithingtable.NameTag;

public class RecipeManager {

    public void load() {
        loadRecipes();
        loadSmithingRecipes();

        loadEnchantedRecipes();
        loadUltimateRecipes();
    }

    public void loadRecipes() {
        IronAxe.recipe();
        IronPickaxe.recipe();
        IronShovel.recipe();
        IronSword.recipe();

        CustomExperienceBottle.customExperienceBottle();

        UnbreakablePickaxe.recipe();
        UnbreakableAxe.recipe();
        UnbreakableShovel.recipe();
        UnbreakableSword.recipe();

        FortuneSword.recipe();
        FortuntePickaxe.recipe();

        ObsidianDestroyer.recipe();

        KnockbackStick.recipe();
    }

    public void loadEnchantedRecipes() {
        EnchantedPickaxe.enchantedPickaxe();
        EnchantedAxe.recipe();
        EnchantedShovel.recipe();
        EnchantedSword.recipe();

        EnchantedHelmet.recipe();
        EnchantedChestplate.recipe();
        EnchantedLeggings.recipe();
        EnchantedBoots.recipe();
    }

    public void loadUltimateRecipes() {
        UltimateAxe.recipe();
        UltimateBow.recipe();
        UltimateShovel.recipe();
        UltimateSilkPickaxe.recipe();
        UltimateFortunePickaxe.recipe();
        UltimateSword.recipe();

        UltimateHelmet.recipe();
        UltimateChestplate.recipe();
        UltimateLeggings.recipe();
        UltimateBoots.recipe();
    }

    public void loadSmithingRecipes() {
        Bedrock.recipe();
        EnchantedGoldenApple.recipe();
        NameTag.recipe();
    }

}
