package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel1;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

public class ItemMcbbsWikiAxeLevel1 extends AxeItem {
    public static IItemTier tierLevel1 = new McbbsWikiTierLevel1();
    public ItemMcbbsWikiAxeLevel1() {
        super(tierLevel1, 5.0F, -3.2F, (new Properties()).group(ModGroupRegistry.McbbsWikiGroup));
    }
}
