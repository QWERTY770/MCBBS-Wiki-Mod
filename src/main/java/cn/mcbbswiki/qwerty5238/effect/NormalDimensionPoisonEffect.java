package cn.mcbbswiki.qwerty5238.effect;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.core.NonNullList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class NormalDimensionPoisonEffect extends MobEffect {
    public NormalDimensionPoisonEffect() {
        super(MobEffectCategory.HARMFUL, 0xff0000);
    }

    @Override
    public void applyEffectTick(@Nonnull LivingEntity entityLivingBaseIn, int amplifier) {
        if (!(entityLivingBaseIn instanceof Player)) return;
        Player playerEntity = (Player) entityLivingBaseIn;
        NonNullList<ItemStack> armorInventory = playerEntity.getInventory().armor;
        NonNullList<Item> items = NonNullList.create();
        for (ItemStack stack : armorInventory) {
            items.add(stack.getItem());
        }
        // TODO: add advancement check
        if (!playerEntity.isDeadOrDying()) {
            playerEntity.hurt(DamageSource.MAGIC, 4 + amplifier);
            playerEntity.causeFoodExhaustion(0.005F * (float)(amplifier + 1));
        }
    }
}
