package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel1;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;

public class ItemMcbbsWikiShovelLevel1 extends ShovelItem {
    public static IItemTier tierLevel1 = new McbbsWikiTierLevel1();
    public ItemMcbbsWikiShovelLevel1() {
        super(tierLevel1, 1.0F, -3.0F, (new Properties()).group(ModGroupRegistry.McbbsWikiGroup));
    }
}
