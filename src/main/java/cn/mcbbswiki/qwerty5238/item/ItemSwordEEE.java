package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ItemSwordEEE extends SwordItem {
    private static final Tier I_ITEM_TIER = new Tier() {
        @Override
        public int getUses() {
            return 1000;
        }

        @Override
        public float getSpeed() {
            return 10.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 4.0F;
        }

        @Override
        public int getLevel() {
            return 2;
        }

        @Override
        public int getEnchantmentValue() {
            return 30;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ItemRegistry.item_eee.get());
        }
    };
    public ItemSwordEEE() {
        super(I_ITEM_TIER, 5, -2.2F, new Item.Properties().tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
