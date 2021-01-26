package cn.mcbbswiki.qwerty5238;

import cn.mcbbswiki.qwerty5238.registry.*;
import cn.mcbbswiki.qwerty5238.util.Unused;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
@Mod(McbbsWiki.ID)
public class McbbsWiki {
    public static final String ID = "mcbbswiki";
    public static final Logger LOGGER = LogManager.getLogger();
    public static ResourceLocation locate(String name)
    {
        return new ResourceLocation(ID, name);
    }

    @Unused
    public static String find(String name)
    {
        return ID + ":" + name;
    }

    public McbbsWiki(){
        BlockRegistry.BLOCKS.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
        ItemRegistry.ITEMS.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
        EntityRegistry.ENTITY_TYPES.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
        FeatureRegistry.FEATURES.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
        BiomeRegistry.BIOMES.register(
                FMLJavaModLoadingContext.get().getModEventBus()
        );
    }
}
