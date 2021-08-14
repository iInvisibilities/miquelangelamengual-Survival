package es.hulk.survival.managers.recipe;

import es.hulk.survival.managers.recipe.recipes.*;
import es.hulk.survival.managers.recipe.smithingtable.Bedrock;
import es.hulk.survival.managers.recipe.smithingtable.EnchantedGoldenApple;
import es.hulk.survival.managers.recipe.smithingtable.NameTag;

public class RecipeManager {

    public void load() {
        loadRecipes();
        loadSmithingRecipes();
    }

    public void loadRecipes() {
        EnchantedPickaxe.enchantedPickaxe();
        EnchantedAxe.recipe();
        EnchantedShovel.recipe();
        EnchantedSword.recipe();

        EnchantedHelmet.recipe();
        EnchantedChestplate.recipe();
        EnchantedLeggings.recipe();
        EnchantedBoots.recipe();

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

        UltimateFortunePickaxe.recipe();
        UltimateBow.recipe();
        UltimateSword.recipe();

        Bow.recipe();

        KnockbackStick.recipe();
    }

    public void loadSmithingRecipes() {
        Bedrock.recipe();
        EnchantedGoldenApple.recipe();
        NameTag.recipe();
    }

}
