package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class ItemSwordEEE extends SwordItem {
    private static final IItemTier I_ITEM_TIER = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 1000;
        }

        @Override
        public float getEfficiency() {
            return 10.0F;
        }

        @Override
        public float getAttackDamage() {
            return 4.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 2;
        }

        @Override
        public int getEnchantability() {
            return 30;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(ItemRegistry.item_eee.get());
        }
    };
    public ItemSwordEEE() {
        super(I_ITEM_TIER, 5, -2.2F, new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }
}
