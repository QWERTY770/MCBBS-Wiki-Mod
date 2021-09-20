package cn.mcbbswiki.qwerty5238.entity.render;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.LargeMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.model.LargeMcbbsWikiMonsterModel;
import cn.mcbbswiki.qwerty5238.entity.model.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class LargeMcbbsWikiMonsterRender extends MobRenderer<LargeMcbbsWikiMonsterEntity, LargeMcbbsWikiMonsterModel> {

    public LargeMcbbsWikiMonsterRender(EntityRendererProvider.Context context) {
        super(context, new LargeMcbbsWikiMonsterModel(context.bakeLayer(ModelLayers.LARGE_MONSTER)), 2F);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ResourceLocation getTextureLocation(LargeMcbbsWikiMonsterEntity entity) {
        return McbbsWiki.locate("textures/entity/large_mcbbswiki_monster.png");
    }
}
