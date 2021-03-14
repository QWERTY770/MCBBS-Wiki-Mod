package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel1;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class ItemMcbbsWikiSwordLevel1 extends SwordItem {
    public static IItemTier tierLevel1 = new McbbsWikiTierLevel1();
    public ItemMcbbsWikiSwordLevel1() {
        super(tierLevel1, 3, -2.4F, (new Item.Properties()).group(ModGroupRegistry.McbbsWikiGroup));
    }
}
