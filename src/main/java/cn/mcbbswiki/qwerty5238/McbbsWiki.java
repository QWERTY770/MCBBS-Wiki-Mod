package cn.mcbbswiki.qwerty5238;

import cn.mcbbswiki.qwerty5238.registry.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

<<<<<<< HEAD
/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
@Mod("mcbbswiki")
public class McbbsWiki {
    public static final String ID = "mcbbswiki";
=======
@Mod(McbbsWiki.id)
public class McbbsWiki {
    // TODO: Please rename to MODID or ID
    public static final String id = "mcbbswiki";
>>>>>>> adca6d0412e61a71eb64d724f6437246e5871df4
    public McbbsWiki(){
        BlockRegistry.BLOCKS.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
        ItemRegistry.ITEMS.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
    }
}
