package cn.mcbbswiki.qwerty5238.entity.render;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.LargeMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.model.LargeMcbbsWikiMonsterModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class LargeMcbbsWikiMonsterRender extends MobRenderer<LargeMcbbsWikiMonsterEntity, LargeMcbbsWikiMonsterModel> {

    public LargeMcbbsWikiMonsterRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new LargeMcbbsWikiMonsterModel(), 1F);
    }

    public LargeMcbbsWikiMonsterRender(EntityRendererManager renderManagerIn, LargeMcbbsWikiMonsterModel entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ResourceLocation getEntityTexture(LargeMcbbsWikiMonsterEntity entity) {
        return new ResourceLocation(McbbsWiki.ID, "textures/entity/large_mcbbswiki_monster.png");
    }
}
