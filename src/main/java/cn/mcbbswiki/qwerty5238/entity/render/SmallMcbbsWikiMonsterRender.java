package cn.mcbbswiki.qwerty5238.entity.render;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.SmallMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.model.ModelLayers;
import cn.mcbbswiki.qwerty5238.entity.model.SmallMcbbsWikiMonsterModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class SmallMcbbsWikiMonsterRender extends MobRenderer<SmallMcbbsWikiMonsterEntity, SmallMcbbsWikiMonsterModel> {
    public SmallMcbbsWikiMonsterRender(EntityRendererProvider.Context context) {
        super(context, new SmallMcbbsWikiMonsterModel(context.bakeLayer(ModelLayers.SMALL_MONSTER)), 1F);
    }

    @Override
    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull SmallMcbbsWikiMonsterEntity entity) {
        return McbbsWiki.locate("textures/entity/small_mcbbswiki_monster.png");
    }
}
