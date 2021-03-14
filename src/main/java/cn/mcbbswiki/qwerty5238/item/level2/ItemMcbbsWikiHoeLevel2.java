package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel2;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;

public class ItemMcbbsWikiHoeLevel2 extends HoeItem {
    public static IItemTier tierLevel2 = new McbbsWikiTierLevel2();
    public ItemMcbbsWikiHoeLevel2() {
        super(tierLevel2, 0, -0.0F, (new Properties()).group(ModGroupRegistry.McbbsWikiGroup));
    }
}
