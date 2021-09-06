package cn.mcbbswiki.qwerty5238.item.level1;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.tooltype.McbbsWikiTierLevel1;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class ItemMcbbsWikiShovelLevel1 extends ShovelItem {
    public static Tier tierLevel1 = new McbbsWikiTierLevel1();
    public ItemMcbbsWikiShovelLevel1() {
        super(tierLevel1, 1.0F, -3.0F, (new Properties()).tab(ModGroupRegistry.McbbsWikiGroup));
    }
}
