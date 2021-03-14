package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel2;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ItemMcbbsWikiHelmetLevel2 extends ArmorItem {
    public ItemMcbbsWikiHelmetLevel2() {
        super(new McbbsWikiMaterialLevel2(), EquipmentSlotType.HEAD, new Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }
}
