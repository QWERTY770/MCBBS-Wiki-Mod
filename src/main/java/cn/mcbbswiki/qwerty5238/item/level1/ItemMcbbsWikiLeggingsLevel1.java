package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiMaterialLevel1;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class ItemMcbbsWikiLeggingsLevel1 extends ArmorItem {
    public ItemMcbbsWikiLeggingsLevel1() {
        super(new McbbsWikiMaterialLevel1(), EquipmentSlot.LEGS, new Properties().tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
