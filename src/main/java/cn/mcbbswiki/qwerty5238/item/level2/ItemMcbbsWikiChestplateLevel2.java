package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel2;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class ItemMcbbsWikiChestplateLevel2 extends ArmorItem {
    public ItemMcbbsWikiChestplateLevel2() {
        super(new McbbsWikiMaterialLevel2(), EquipmentSlot.CHEST, new Properties().tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
