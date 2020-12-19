package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.material.McbbsWikiMaterialLevel1;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ItemMcbbsWikiLeggingsLevel1 extends ArmorItem {
    public ItemMcbbsWikiLeggingsLevel1() {
        super(new McbbsWikiMaterialLevel1(), EquipmentSlotType.LEGS, new Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }
}
