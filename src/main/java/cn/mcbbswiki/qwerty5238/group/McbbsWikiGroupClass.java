package cn.mcbbswiki.qwerty5238.group;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
public class McbbsWikiGroupClass extends ItemGroup {
    public McbbsWikiGroupClass(){
        super("mcbbswiki_group");
    }
    @Override @Nonnull
    public ItemStack createIcon(){
        return new ItemStack(ItemRegistry.item_mcbbswiki_ingot.get());
    }
}
