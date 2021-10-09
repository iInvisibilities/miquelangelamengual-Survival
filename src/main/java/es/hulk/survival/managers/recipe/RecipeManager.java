package es.hulk.survival.managers.recipe;

import es.hulk.survival.managers.recipe.recipes.coal.CoalSword;
import es.hulk.survival.managers.recipe.recipes.iron.IronAxe;
import es.hulk.survival.managers.recipe.recipes.iron.IronPickaxe;
import es.hulk.survival.managers.recipe.recipes.iron.IronShovel;
import es.hulk.survival.managers.recipe.recipes.iron.IronSword;
import es.hulk.survival.managers.recipe.smithingtable.EnchantedGoldenApple;
import es.hulk.survival.managers.recipe.smithingtable.NameTag;

public class RecipeManager {

    public void load() {
        NameTag.load();
        EnchantedGoldenApple.load();
        CoalSword.load();

        IronAxe.load();
        IronShovel.load();
        IronPickaxe.load();
        IronSword.load();
    }
}
