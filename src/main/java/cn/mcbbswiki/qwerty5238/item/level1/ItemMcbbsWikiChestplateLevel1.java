package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel1;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class ItemMcbbsWikiChestplateLevel1 extends ArmorItem {
    public ItemMcbbsWikiChestplateLevel1() {
        super(new McbbsWikiMaterialLevel1(), EquipmentSlot.CHEST, new Properties().tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
