package cn.mcbbswiki.qwerty5238.tooltype;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class McbbsWikiTierLevel2 implements Tier {
    @Override
    public int getUses() {
        return 2500;
    }

    @Override
    public float getSpeed() {
        return 9F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 5F;
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public int getEnchantmentValue() {
        return 20;
    }

    @Override
    @Nonnull
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemRegistry.item_mysterious_ingot.get());
    }
}
