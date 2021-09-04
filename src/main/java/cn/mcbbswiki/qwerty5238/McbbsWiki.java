package cn.mcbbswiki.qwerty5238;

import cn.mcbbswiki.qwerty5238.registry.RegistryHandler;
import cn.mcbbswiki.qwerty5238.util.Unused;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
@Mod(McbbsWiki.ID)
public class McbbsWiki {
    // 1.17.1 incomplete version
    // Do not use it now
    public static final String ID = "mcbbswiki";
    @Unused
    public static final Logger LOGGER = LogManager.getLogger();
    @Unused
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
        RegistryHandler.register();
    }
}
