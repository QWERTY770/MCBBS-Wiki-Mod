package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel2;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class ItemMcbbsWikiSwordLevel2 extends SwordItem {
    public static IItemTier tierLevel2 = new McbbsWikiTierLevel2();
    public ItemMcbbsWikiSwordLevel2() {
        super(tierLevel2, 3, -2.4F, (new Properties()).group(ModGroupRegistry.McbbsWikiGroup));
    }
}
