package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel1;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ItemMcbbsWikiChestplateLevel1 extends ArmorItem {
    public ItemMcbbsWikiChestplateLevel1() {
        super(new McbbsWikiMaterialLevel1(), EquipmentSlotType.CHEST, new Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }
}
