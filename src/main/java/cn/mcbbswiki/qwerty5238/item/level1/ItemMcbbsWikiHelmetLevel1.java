package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel1;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class ItemMcbbsWikiHelmetLevel1 extends ArmorItem {
    public ItemMcbbsWikiHelmetLevel1() {
        super(new McbbsWikiMaterialLevel1(), EquipmentSlot.HEAD, new Item.Properties().tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
