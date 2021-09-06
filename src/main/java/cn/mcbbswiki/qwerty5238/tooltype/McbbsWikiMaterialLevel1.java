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

public class McbbsWikiMaterialLevel1 implements ArmorMaterial {
    @Override
    @ParametersAreNonnullByDefault
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        int[] myDur = {380, 550, 510, 450};
        return myDur[slotIn.getIndex()];
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        int[] myDam = {3, 6, 8, 3};
        return myDam[slotIn.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return 12;
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
        return Ingredient.of(ItemRegistry.item_mcbbswiki_ingot.get());
    }

    @Override
    @Nonnull
    public String getName() {
        return "mcbbswiki:material_level1";
    }

    @Override
    public float getToughness() {
        return 2.3F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.03F;
    }
}
