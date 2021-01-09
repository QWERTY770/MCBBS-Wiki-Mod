package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel1;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ItemMcbbsWikiBootsLevel1 extends ArmorItem {
    public ItemMcbbsWikiBootsLevel1() {
        super(new McbbsWikiMaterialLevel1(), EquipmentSlotType.FEET, new Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }
}
