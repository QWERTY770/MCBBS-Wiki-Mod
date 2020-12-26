package cn.mcbbswiki.qwerty5238;

import cn.mcbbswiki.qwerty5238.registry.*;
import cn.mcbbswiki.qwerty5238.world.ore.OverWorldModFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
@Mod(McbbsWiki.ID)
public class McbbsWiki {
    public static final String ID = "mcbbswiki";
    public McbbsWiki(){
        BlockRegistry.BLOCKS.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
        ItemRegistry.ITEMS.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
        BiomeRegistry.BIOMES.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
    }
}
