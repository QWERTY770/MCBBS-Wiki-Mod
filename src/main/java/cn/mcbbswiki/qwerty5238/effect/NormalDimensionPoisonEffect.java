package cn.mcbbswiki.qwerty5238.effect;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.NonNullList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NormalDimensionPoisonEffect extends MobEffect {
    public NormalDimensionPoisonEffect() {
        super(MobEffectCategory.HARMFUL, 0xff0000);
    }

    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier) {
        if (!(entityLivingBaseIn instanceof Player)) return;
        Player playerEntity = (Player) entityLivingBaseIn;
        NonNullList<ItemStack> armorInventory = playerEntity.getInventory().armor;
        NonNullList<Item> items = NonNullList.create();
        for (ItemStack stack : armorInventory) {
            items.add(stack.getItem());
        }
        if (!(items.contains(ItemRegistry.item_mcbbswiki_helmet_level2.get()) ||
                items.contains(ItemRegistry.item_mcbbswiki_chestplate_level2.get()) ||
                items.contains(ItemRegistry.item_mcbbswiki_leggings_level2.get()) ||
                items.contains(ItemRegistry.item_mcbbswiki_boots_level2.get())) && playerEntity.isEntityUndead()) {
            playerEntity.attackEntityFrom(DamageSource.MAGIC, 5 << amplifier);
            playerEntity.addExhaustion(0.005F * (float)(amplifier + 1));
        }
    }
}
