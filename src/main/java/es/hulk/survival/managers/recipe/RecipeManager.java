package es.hulk.survival.managers.recipe;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.recipe.recipes.*;
import es.hulk.survival.managers.recipe.smithingtable.Bedrock;

public class RecipeManager {

    private Survival plugin;

    public void load() {
        loadRecipes();
        loadSmithingRecipes();
    }

    public void loadRecipes() {
        EnchantedPickaxe.enchantedPickaxe();
        EnchantedAxe.recipe();
        EnchantedShovel.recipe();
        EnchantedSword.recipe();

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
    }

    public void loadSmithingRecipes() {
        Bedrock.recipe();
    }

}
