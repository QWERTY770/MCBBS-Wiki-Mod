package cn.mcbbswiki.qwerty5238.effect;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NormalDimensionPoisonEffect extends Effect {
    public NormalDimensionPoisonEffect() {
        super(EffectType.HARMFUL, 0xff0000);
    }

    @Override
    public void performEffect(@Nonnull LivingEntity entityLivingBaseIn, int amplifier) {
        if (!(entityLivingBaseIn instanceof PlayerEntity)) return;
        PlayerEntity playerEntity = (PlayerEntity) entityLivingBaseIn;
        NonNullList<ItemStack> armorInventory = playerEntity.inventory.armorInventory;
        NonNullList<Item> items = NonNullList.create();
        for (ItemStack stack : armorInventory) {
            items.add(stack.getItem());
        }
        if (!(items.contains(ItemRegistry.item_mcbbswiki_helmet_level2.get()) ||
                items.contains(ItemRegistry.item_mcbbswiki_chestplate_level2.get()) ||
                items.contains(ItemRegistry.item_mcbbswiki_leggings_level2.get()) ||
                items.contains(ItemRegistry.item_mcbbswiki_boots_level2.get()) && playerEntity.isEntityUndead())) {
            playerEntity.attackEntityFrom(DamageSource.MAGIC, 5 << amplifier);
            playerEntity.addExhaustion(0.005F * (float)(amplifier + 1));
        }
    }

    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, @Nonnull LivingEntity entityLivingBaseIn, int amplifier, double health){
        this.performEffect(entityLivingBaseIn, amplifier);
    }
}
