package cn.mcbbswiki.qwerty5238.entity.model;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

// see net/minecraft/client/model/geom/LayerDefinitions.java
@OnlyIn(Dist.CLIENT)
public class LayerDefinitions {
    public static Map<ModelLayerLocation, LayerDefinition> createRoots() {
        ImmutableMap.Builder<ModelLayerLocation, LayerDefinition> builder = ImmutableMap.builder();
        builder.put(ModelLayers.SMALL_MONSTER, SmallMcbbsWikiMonsterModel.createBodyLayer());
        builder.put(ModelLayers.MIDDLE_MONSTER, MiddleMcbbsWikiMonsterModel.createBodyLayer());
        builder.put(ModelLayers.LARGE_MONSTER, LargeMcbbsWikiMonsterModel.createBodyLayer());
        builder.put(ModelLayers.RAY_OF_SUNSHINE, RayOfSunshineModel.createBodyLayer());

        return builder.build();
    }
}
