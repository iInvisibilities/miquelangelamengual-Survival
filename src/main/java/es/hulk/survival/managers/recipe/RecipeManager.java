package es.hulk.survival.managers.recipe;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.recipe.recipes.*;

public class RecipeManager {

    private Survival plugin;

    public void loadRecipes() {
        EnchantedPickaxe.enchantedPickaxe();
        EnchantedAxe.recipe();
        EnchantedShovel.recipe();
        EnchantedSword.recipe();

        CustomExperienceBottle.customExperienceBottle();

        UnbreakablePickaxe.recipe();
        UnbreakableAxe.recipe();
        UnbreakableShovel.recipe();
        UnbreakableSword.recipe();

        FortuneSword.recipe();
        FortuntePickaxe.recipe();

        ObsidianDestroyer.recipe();
    }

}
