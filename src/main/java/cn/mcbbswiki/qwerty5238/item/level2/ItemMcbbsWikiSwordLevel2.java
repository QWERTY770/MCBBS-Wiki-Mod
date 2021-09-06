package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel2;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ItemMcbbsWikiSwordLevel2 extends SwordItem {
    public static Tier tierLevel2 = new McbbsWikiTierLevel2();
    public ItemMcbbsWikiSwordLevel2() {
        super(tierLevel2, 3, -2.4F, (new Properties()).tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
