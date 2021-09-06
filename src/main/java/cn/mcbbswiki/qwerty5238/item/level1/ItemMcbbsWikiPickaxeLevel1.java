package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel1;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class ItemMcbbsWikiPickaxeLevel1 extends PickaxeItem {
    public static Tier tierLevel1 = new McbbsWikiTierLevel1();
    public ItemMcbbsWikiPickaxeLevel1() {
        super(tierLevel1, 1, -2.8F, (new Properties()).tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
