package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel2;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class ItemMcbbsWikiPickaxeLevel2 extends PickaxeItem {
    public static Tier tierLevel2 = new McbbsWikiTierLevel2();
    public ItemMcbbsWikiPickaxeLevel2() {
        super(tierLevel2, 1, -2.8F, (new Properties()).tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
