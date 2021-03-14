package cn.mcbbswiki.qwerty5238.tooltype;

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

public class McbbsWikiMaterialLevel2 implements IArmorMaterial {
    @Override
    @ParametersAreNonnullByDefault
    public int getDurability(EquipmentSlotType slotIn) {
        int[] myDur = {580, 750, 710, 650};
        return myDur[slotIn.getIndex()];
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        int[] myDam = {4, 7, 9, 4};
        return myDam[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    @Nonnull
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    @Nonnull
    @OnlyIn(Dist.CLIENT)
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ItemRegistry.item_mysterious_ingot.get());
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
