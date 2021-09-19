package cn.mcbbswiki.qwerty5238.entity.model;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import com.google.common.collect.Sets;
import net.minecraft.client.model.geom.ModelLayerLocation;

import java.util.Set;


// see net/minecraft/client/model/geom/ModelLayers.java
public class ModelLayers {
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation SMALL_MONSTER = register("small_mcbbswiki_monster");
    public static final ModelLayerLocation MIDDLE_MONSTER = register("middle_mcbbswiki_monster");
    public static final ModelLayerLocation LARGE_MONSTER = register("large_mcbbswiki_monster");

    private static ModelLayerLocation register(String p_171294_) {
        return register(p_171294_, "main");
    }

    private static ModelLayerLocation register(String p_171296_, String p_171297_) {
        ModelLayerLocation modellayerlocation = createLocation(p_171296_, p_171297_);
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
        return new ModelLayerLocation(McbbsWiki.locate(p_171301_), p_171302_);
    }
}
