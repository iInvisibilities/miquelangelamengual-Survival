package es.hulk.survival.managers.recipe;

import es.hulk.survival.managers.recipe.recipes.coal.CoalAxe;
import es.hulk.survival.managers.recipe.recipes.coal.CoalPickaxe;
import es.hulk.survival.managers.recipe.recipes.coal.CoalShovel;
import es.hulk.survival.managers.recipe.recipes.coal.CoalSword;
import es.hulk.survival.managers.recipe.recipes.diamond.DiamondAxe;
import es.hulk.survival.managers.recipe.recipes.diamond.DiamondPickaxe;
import es.hulk.survival.managers.recipe.recipes.diamond.DiamondShovel;
import es.hulk.survival.managers.recipe.recipes.diamond.DiamondSword;
import es.hulk.survival.managers.recipe.recipes.diamond.armor.DiamondBoots;
import es.hulk.survival.managers.recipe.recipes.diamond.armor.DiamondChestplate;
import es.hulk.survival.managers.recipe.recipes.diamond.armor.DiamondHelmet;
import es.hulk.survival.managers.recipe.recipes.diamond.armor.DiamondLeggings;
import es.hulk.survival.managers.recipe.recipes.gold.GoldAxe;
import es.hulk.survival.managers.recipe.recipes.gold.GoldPickaxe;
import es.hulk.survival.managers.recipe.recipes.gold.GoldShovel;
import es.hulk.survival.managers.recipe.recipes.gold.GoldSword;
import es.hulk.survival.managers.recipe.recipes.gold.armor.GoldBoots;
import es.hulk.survival.managers.recipe.recipes.gold.armor.GoldChestplate;
import es.hulk.survival.managers.recipe.recipes.gold.armor.GoldHelmet;
import es.hulk.survival.managers.recipe.recipes.gold.armor.GoldLeggings;
import es.hulk.survival.managers.recipe.recipes.iron.IronAxe;
import es.hulk.survival.managers.recipe.recipes.iron.IronPickaxe;
import es.hulk.survival.managers.recipe.recipes.iron.IronShovel;
import es.hulk.survival.managers.recipe.recipes.iron.IronSword;
import es.hulk.survival.managers.recipe.recipes.iron.armor.IronBoots;
import es.hulk.survival.managers.recipe.recipes.iron.armor.IronChestplate;
import es.hulk.survival.managers.recipe.recipes.iron.armor.IronHelmet;
import es.hulk.survival.managers.recipe.recipes.iron.armor.IronLeggins;
import es.hulk.survival.managers.recipe.recipes.netherite.*;
import es.hulk.survival.managers.recipe.recipes.netherite.armor.NetheriteBoots;
import es.hulk.survival.managers.recipe.recipes.netherite.armor.NetheriteChestplate;
import es.hulk.survival.managers.recipe.recipes.netherite.armor.NetheriteHelmet;
import es.hulk.survival.managers.recipe.recipes.netherite.armor.NetheriteLeggings;
import es.hulk.survival.managers.recipe.recipes.other.*;
import es.hulk.survival.managers.recipe.recipes.wood.WoodAxe;
import es.hulk.survival.managers.recipe.recipes.wood.WoodPickaxe;
import es.hulk.survival.managers.recipe.recipes.wood.WoodShovel;
import es.hulk.survival.managers.recipe.recipes.wood.WoodSword;
import es.hulk.survival.managers.recipe.smithingtable.EnchantedGoldenApple;
import es.hulk.survival.managers.recipe.smithingtable.NameTag;

public class RecipeManager {

    public void load() {
        NameTag.load();
        EnchantedGoldenApple.load();

        WoodSword.load();
        WoodPickaxe.load();
        WoodAxe.load();
        WoodShovel.load();

        CoalSword.load();
        CoalPickaxe.load();
        CoalAxe.load();
        CoalShovel.load();

        IronAxe.load();
        IronShovel.load();
        IronPickaxe.load();
        IronSword.load();
        IronHelmet.load();
        IronChestplate.load();
        IronLeggins.load();
        IronBoots.load();

        DiamondSword.load();
        DiamondPickaxe.load();
        DiamondAxe.load();
        DiamondShovel.load();
        DiamondHelmet.load();
        DiamondChestplate.load();
        DiamondLeggings.load();
        DiamondBoots.load();

        GoldSword.load();
        GoldPickaxe.load();
        GoldAxe.load();
        GoldShovel.load();
        GoldHelmet.load();
        GoldChestplate.load();
        GoldLeggings.load();
        GoldBoots.load();

        NetheriteSword.load();
        NetheriteFortunePickaxe.load();
        NetheriteSilkPickaxe.load();
        NetheriteAxe.load();
        NetheriteShovel.load();
        NetheriteHelmet.load();
        NetheriteChestplate.load();
        NetheriteLeggings.load();
        NetheriteBoots.load();

        CustomExperienceBottle.load();
        FortuneSword.load();
        FortunePickaxe.load();
        KnockbackStick.load();
        UltimateBow.load();
    }
}
