package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel2;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class ItemMcbbsWikiShovelLevel2 extends ShovelItem {
    public static Tier tierLevel2 = new McbbsWikiTierLevel2();
    public ItemMcbbsWikiShovelLevel2() {
        super(tierLevel2, 1.0F, -3.0F, (new Properties()).tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
