package cn.mcbbswiki.qwerty5238.entity;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.model.LayerDefinitions;
import cn.mcbbswiki.qwerty5238.entity.render.LargeMcbbsWikiMonsterRender;
import cn.mcbbswiki.qwerty5238.entity.render.MiddleMcbbsWikiMonsterRender;
import cn.mcbbswiki.qwerty5238.entity.render.RayOfSunshineRender;
import cn.mcbbswiki.qwerty5238.entity.render.SmallMcbbsWikiMonsterRender;
import cn.mcbbswiki.qwerty5238.registry.EntityRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = McbbsWiki.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterEntityRender {
    @SubscribeEvent
    public static void onEntityRenderersEvent(EntityRenderersEvent.RegisterRenderers event) {
        // register entity renderers
        // 1.17
        event.registerEntityRenderer(EntityRegistry.entity_small_mcbbswiki_monster.get(), SmallMcbbsWikiMonsterRender::new);
        event.registerEntityRenderer(EntityRegistry.entity_middle_mcbbswiki_monster.get(), MiddleMcbbsWikiMonsterRender::new);
        event.registerEntityRenderer(EntityRegistry.entity_large_mcbbswiki_monster.get(), LargeMcbbsWikiMonsterRender::new);
        event.registerEntityRenderer(EntityRegistry.entity_ray_of_sunshine.get(), RayOfSunshineRender::new);
    }

    @SubscribeEvent
    public static void onLayerDefinitionEvent(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // register layer definitions
        // 1.17
        Map<ModelLayerLocation, LayerDefinition> roots = LayerDefinitions.createRoots();
        for (ModelLayerLocation location : roots.keySet()){
            event.registerLayerDefinition(location, () -> roots.get(location));
        }
    }
}

