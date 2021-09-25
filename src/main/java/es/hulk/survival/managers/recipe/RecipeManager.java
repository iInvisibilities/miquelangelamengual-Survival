package es.hulk.survival.managers.recipe;

import es.hulk.survival.managers.recipe.recipes.ironblock.IronPickaxe;
import es.hulk.survival.managers.recipe.smithingtable.EnchantedGoldenApple;
import es.hulk.survival.managers.recipe.smithingtable.NameTag;

public class RecipeManager {

    public void load() {
        new IronPickaxe();
        new EnchantedGoldenApple();
        new NameTag();
    }
}
