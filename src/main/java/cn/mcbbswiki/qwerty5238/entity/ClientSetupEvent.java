package cn.mcbbswiki.qwerty5238.entity;

import cn.mcbbswiki.qwerty5238.entity.render.LargeMcbbsWikiMonsterRender;
import cn.mcbbswiki.qwerty5238.entity.render.MiddleMcbbsWikiMonsterRender;
import cn.mcbbswiki.qwerty5238.entity.render.SmallMcbbsWikiMonsterRender;
import cn.mcbbswiki.qwerty5238.registry.EntityRegistry;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvent {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.entity_small_mcbbswiki_monster.get(), (EntityRendererManager manager) -> new SmallMcbbsWikiMonsterRender(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.entity_middle_mcbbswiki_monster.get(), (EntityRendererManager manager) -> new MiddleMcbbsWikiMonsterRender(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.entity_large_mcbbswiki_monster.get(), (EntityRendererManager manager) -> new LargeMcbbsWikiMonsterRender(manager));
    }
}

