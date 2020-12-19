package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.item.Item;

public class ItemMcbbsWikiIngot extends Item {
    public ItemMcbbsWikiIngot() {
        super(new Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }
}
