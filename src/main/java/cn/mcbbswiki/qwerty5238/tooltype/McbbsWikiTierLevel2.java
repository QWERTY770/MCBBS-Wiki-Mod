package cn.mcbbswiki.qwerty5238.tooltype;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class McbbsWikiTierLevel2 implements IItemTier {
    @Override
    public int getMaxUses() {
        return 2500;
    }

    @Override
    public float getEfficiency() {
        return 9F;
    }

    @Override
    public float getAttackDamage() {
        return 5F;
    }

    @Override
    public int getHarvestLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    @Nonnull
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ItemRegistry.item_mysterious_ingot.get());
    }
}
