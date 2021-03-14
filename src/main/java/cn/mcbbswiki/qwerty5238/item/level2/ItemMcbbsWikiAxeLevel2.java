package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel2;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

public class ItemMcbbsWikiAxeLevel2 extends AxeItem {
    public static IItemTier tierLevel2 = new McbbsWikiTierLevel2();
    public ItemMcbbsWikiAxeLevel2() {
        super(tierLevel2, 5.0F, -3.2F, (new Properties()).group(ModGroupRegistry.McbbsWikiGroup));
    }
}
