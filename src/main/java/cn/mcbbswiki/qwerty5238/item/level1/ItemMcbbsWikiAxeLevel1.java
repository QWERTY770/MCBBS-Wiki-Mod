package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel1;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class ItemMcbbsWikiAxeLevel1 extends AxeItem {
    public static Tier tierLevel1 = new McbbsWikiTierLevel1();
    public ItemMcbbsWikiAxeLevel1() {
        super(tierLevel1, 5.0F, -3.2F, (new Properties()).tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
