package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel2;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class ItemMcbbsWikiBootsLevel2 extends ArmorItem {
    public ItemMcbbsWikiBootsLevel2() {
        super(new McbbsWikiMaterialLevel2(), EquipmentSlot.FEET, new Properties().tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
