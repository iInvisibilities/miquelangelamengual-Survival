package es.hulk.survival.managers.recipe;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.recipe.recipes.*;

public class RecipeManager {

    private Survival plugin;

    public void loadRecipes() {
        EnchantedPickaxe.enchantedPickaxe();
        CustomExperienceBottle.customExperienceBottle();
        UnbreakablePickaxe.recipe();
        FortuneSword.recipe();
        FortuntePickaxe.recipe();
    }

}
