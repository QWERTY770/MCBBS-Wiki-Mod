package cn.mcbbswiki.qwerty5238.entity.render;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.SmallMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.model.SmallMcbbsWikiMonsterModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class SmallMcbbsWikiMonsterRender extends MobRenderer<SmallMcbbsWikiMonsterEntity, SmallMcbbsWikiMonsterModel> {

    public SmallMcbbsWikiMonsterRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SmallMcbbsWikiMonsterModel(), 1F);
    }

    public SmallMcbbsWikiMonsterRender(EntityRendererManager renderManagerIn, SmallMcbbsWikiMonsterModel entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ResourceLocation getEntityTexture(SmallMcbbsWikiMonsterEntity entity) {
        return new ResourceLocation(McbbsWiki.ID, "textures/entity/small_mcbbswiki_monster.png");
    }
}
