package cn.mcbbswiki.qwerty5238.entity.render;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.MiddleMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.model.MiddleMcbbsWikiMonsterModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class MiddleMcbbsWikiMonsterRender extends MobRenderer<MiddleMcbbsWikiMonsterEntity, MiddleMcbbsWikiMonsterModel> {

    public MiddleMcbbsWikiMonsterRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MiddleMcbbsWikiMonsterModel(), 1F);
    }

    public MiddleMcbbsWikiMonsterRender(EntityRendererManager renderManagerIn, MiddleMcbbsWikiMonsterModel entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ResourceLocation getEntityTexture(MiddleMcbbsWikiMonsterEntity entity) {
        return new ResourceLocation(McbbsWiki.ID, "textures/entity/middle_mcbbswiki_monster.png");
    }
}
