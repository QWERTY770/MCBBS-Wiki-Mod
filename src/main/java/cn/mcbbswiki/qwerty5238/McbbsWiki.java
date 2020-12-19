package cn.mcbbswiki.qwerty5238;

import cn.mcbbswiki.qwerty5238.registry.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(McbbsWiki.id)
public class McbbsWiki {
    // TODO: Please rename to MODID or ID
    public static final String id = "mcbbswiki";
    public McbbsWiki(){
        BlockRegistry.BLOCKS.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
        ItemRegistry.ITEMS.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
    }
}
