package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel1;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;

public class ItemMcbbsWikiHoeLevel1 extends HoeItem {
    public static IItemTier tierLevel1 = new McbbsWikiTierLevel1();
    public ItemMcbbsWikiHoeLevel1() {
        super(tierLevel1, 0, -0.0F, (new Properties()).group(ModGroupRegistry.McbbsWikiGroup));
    }
}
