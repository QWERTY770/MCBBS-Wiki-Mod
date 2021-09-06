package cn.mcbbswiki.qwerty5238.tooltype;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class McbbsWikiTierLevel1 implements Tier {
    @Override
    public int getUses() {
        return 1800;
    }

    @Override
    public float getSpeed() {
        return 8.5F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 3.5F;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 12;
    }

    @Override
    @Nonnull
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemRegistry.item_mcbbswiki_ingot.get());
    }
}
