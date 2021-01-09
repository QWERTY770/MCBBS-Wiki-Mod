package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel1;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class ItemMcbbsWikiHelmetLevel1 extends ArmorItem {
    public ItemMcbbsWikiHelmetLevel1() {
        super(new McbbsWikiMaterialLevel1(), EquipmentSlotType.HEAD, new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }
}
