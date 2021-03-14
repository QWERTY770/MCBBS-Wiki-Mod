package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel2;
import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class ItemMcbbsWikiPickaxeLevel2 extends PickaxeItem {
    public static IItemTier tierLevel2 = new McbbsWikiTierLevel2();
    public ItemMcbbsWikiPickaxeLevel2() {
        super(tierLevel2, 1, -2.8F, (new Properties()).group(ModGroupRegistry.McbbsWikiGroup));
    }
}
