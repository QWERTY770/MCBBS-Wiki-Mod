package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.item.CustomSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = McbbsWiki.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    public static void register(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockRegistry.BLOCKS.register(bus);
        EntityRegistry.ENTITY_TYPES.register(bus);
        ItemRegistry.ITEMS.register(bus);
        FeatureRegistry.FEATURES.register(bus);
        BiomeRegistry.BIOMES.register(bus);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPostRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        CustomSpawnEggItem.initUnaddedEggs();
    }
}
