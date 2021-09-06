package cn.mcbbswiki.qwerty5238.group;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
public class McbbsWikiGroupClass extends CreativeModeTab {
    public McbbsWikiGroupClass(){
        super("mcbbswiki_group");
    }
    @Override @Nonnull
    public ItemStack makeIcon(){
        return new ItemStack(ItemRegistry.item_mcbbswiki_ingot.get());
    }
}
