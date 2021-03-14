package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel1;
import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class ItemMcbbsWikiPickaxeLevel1 extends PickaxeItem {
    public static IItemTier tierLevel1 = new McbbsWikiTierLevel1();
    public ItemMcbbsWikiPickaxeLevel1() {
        super(tierLevel1, 1, -2.8F, (new Properties()).group(ModGroupRegistry.McbbsWikiGroup));
    }
}
