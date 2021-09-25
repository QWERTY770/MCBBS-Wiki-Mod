package cn.mcbbswiki.qwerty5238.entity.render;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.MiddleMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.model.MiddleMcbbsWikiMonsterModel;
import cn.mcbbswiki.qwerty5238.entity.model.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class MiddleMcbbsWikiMonsterRender extends MobRenderer<MiddleMcbbsWikiMonsterEntity, MiddleMcbbsWikiMonsterModel> {

    public MiddleMcbbsWikiMonsterRender(EntityRendererProvider.Context context) {
        super(context, new MiddleMcbbsWikiMonsterModel(context.bakeLayer(ModelLayers.MIDDLE_MONSTER)), 1.5F);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ResourceLocation getTextureLocation(MiddleMcbbsWikiMonsterEntity entity) {
        return McbbsWiki.locate("textures/entity/middle_mcbbswiki_monster/middle_mcbbswiki_monster.png");
    }
}
