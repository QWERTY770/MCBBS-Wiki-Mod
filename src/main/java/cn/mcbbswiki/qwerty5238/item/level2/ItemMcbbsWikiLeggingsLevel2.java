package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel2;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ItemMcbbsWikiLeggingsLevel2 extends ArmorItem {
    public ItemMcbbsWikiLeggingsLevel2() {
        super(new McbbsWikiMaterialLevel2(), EquipmentSlotType.LEGS, new Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }
}
