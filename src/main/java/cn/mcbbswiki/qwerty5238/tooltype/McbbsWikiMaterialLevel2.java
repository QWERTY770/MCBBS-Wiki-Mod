package cn.mcbbswiki.qwerty5238.tooltype;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class McbbsWikiMaterialLevel2 implements ArmorMaterial {
    @Override
    @ParametersAreNonnullByDefault
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        int[] myDur = {580, 750, 710, 650};
        return myDur[slotIn.getIndex()];
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        int[] myDam = {4, 7, 9, 4};
        return myDam[slotIn.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return 20;
    }

    @Override
    @Nonnull
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @Override
    @Nonnull
    @OnlyIn(Dist.CLIENT)
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemRegistry.item_mysterious_ingot.get());
    }

    @Override
    @Nonnull
    public String getName() {
        return "mcbbswiki:material_level2";
    }

    @Override
    public float getToughness() {
        return 3.5F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.15F;
    }
}