package es.hulk.survival.managers.recipe;

import es.hulk.survival.managers.recipe.recipes.coal.CoalSword;
import es.hulk.survival.managers.recipe.smithingtable.EnchantedGoldenApple;
import es.hulk.survival.managers.recipe.smithingtable.NameTag;

public class RecipeManager {

    public void load() {
        NameTag.load();
        EnchantedGoldenApple.load();
        CoalSword.load();
    }
}
