package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel1;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ItemMcbbsWikiSwordLevel1 extends SwordItem {
    public static Tier tierLevel1 = new McbbsWikiTierLevel1();
    public ItemMcbbsWikiSwordLevel1() {
        super(tierLevel1, 3, -2.4F, (new Properties()).tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
