package cn.mcbbswiki.qwerty5238.material;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class McbbsWikiMaterialLevel1 implements IArmorMaterial {
    @Override
    @ParametersAreNonnullByDefault
    public int getDurability(EquipmentSlotType slotIn) {
        int[] myDur = {380, 550, 510, 450};
        return myDur[slotIn.getIndex()];
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        int[] myDam = {3, 6, 8, 3};
        return myDam[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    @Nonnull
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    @Nonnull
    @OnlyIn(Dist.CLIENT)
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ItemRegistry.item_mcbbswiki_ingot.get());
    }

    @Override
    @Nonnull
    public String getName() {
        return "mcbbswiki:material_level1";
    }

    @Override
    public float getToughness() {
        return 2.1F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.03F;
    }
}
