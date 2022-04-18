package es.hulk.survival.managers.recipe;

import es.hulk.survival.managers.recipe.recipes.coal.CoalAxe;
import es.hulk.survival.managers.recipe.recipes.coal.CoalPickaxe;
import es.hulk.survival.managers.recipe.recipes.coal.CoalShovel;
import es.hulk.survival.managers.recipe.recipes.coal.CoalSword;
import es.hulk.survival.managers.recipe.recipes.diamond.*;
import es.hulk.survival.managers.recipe.recipes.diamond.armor.DiamondBoots;
import es.hulk.survival.managers.recipe.recipes.diamond.armor.DiamondChestplate;
import es.hulk.survival.managers.recipe.recipes.diamond.armor.DiamondHelmet;
import es.hulk.survival.managers.recipe.recipes.diamond.armor.DiamondLeggings;
import es.hulk.survival.managers.recipe.recipes.emerald.EmeraldAxe;
import es.hulk.survival.managers.recipe.recipes.emerald.EmeraldPickaxe;
import es.hulk.survival.managers.recipe.recipes.emerald.EmeraldShovel;
import es.hulk.survival.managers.recipe.recipes.emerald.EmeraldSword;
import es.hulk.survival.managers.recipe.recipes.emerald.armor.EmeraldBoots;
import es.hulk.survival.managers.recipe.recipes.emerald.armor.EmeraldChestplate;
import es.hulk.survival.managers.recipe.recipes.emerald.armor.EmeraldHelmet;
import es.hulk.survival.managers.recipe.recipes.emerald.armor.EmeraldLeggings;
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
import es.hulk.survival.managers.recipe.recipes.stone.StoneAxe;
import es.hulk.survival.managers.recipe.recipes.stone.StonePickaxe;
import es.hulk.survival.managers.recipe.recipes.stone.StoneShovel;
import es.hulk.survival.managers.recipe.recipes.stone.StoneSword;
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

        StoneSword.load();
        StonePickaxe.load();
        StoneAxe.load();
        StoneShovel.load();

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

        GoldSword.load();
        GoldPickaxe.load();
        GoldAxe.load();
        GoldShovel.load();
        GoldHelmet.load();
        GoldChestplate.load();
        GoldLeggings.load();
        GoldBoots.load();

        DiamondSword.load();
        DiamondFortunePickaxe.load();
        DiamondSilkTouchPickaxe.load();
        DiamondEffiencyPickaxe.load();
        DiamondAxe.load();
        DiamondShovel.load();
        DiamondHelmet.load();
        DiamondChestplate.load();
        DiamondLeggings.load();
        DiamondBoots.load();

        EmeraldSword.load();
        EmeraldPickaxe.load();
        EmeraldAxe.load();
        EmeraldShovel.load();
        EmeraldHelmet.load();
        EmeraldChestplate.load();
        EmeraldLeggings.load();
        EmeraldBoots.load();

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
        EnderPearlRecipe.load();
    }
}
