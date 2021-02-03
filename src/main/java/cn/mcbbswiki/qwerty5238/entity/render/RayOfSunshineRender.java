package cn.mcbbswiki.qwerty5238.entity.render;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.RayOfSunshineEntity;
import cn.mcbbswiki.qwerty5238.entity.model.RayOfSunshineModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class RayOfSunshineRender extends MobRenderer<RayOfSunshineEntity, RayOfSunshineModel> {
    private static final ResourceLocation DEFAULT_TEXTURES = McbbsWiki.locate("textures/entity/boss/ray_of_sunshine_default.png");
    private static final ResourceLocation FIREBALL_TEXTURES = McbbsWiki.locate("textures/entity/boss/ray_of_sunshine_fireball.png");
    private static final ResourceLocation FLUID_TEXTURES = McbbsWiki.locate("textures/entity/boss/ray_of_sunshine_fluid.png");

    public RayOfSunshineRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RayOfSunshineModel(), 3F);
    }

    public RayOfSunshineRender(EntityRendererManager renderManagerIn, RayOfSunshineModel entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ResourceLocation getEntityTexture(RayOfSunshineEntity entity) {
        switch (entity.getAttackState()){
            case 0:
                return DEFAULT_TEXTURES;
            case 1:
                return FIREBALL_TEXTURES;
            case 2:
                return FLUID_TEXTURES;
        }
        return DEFAULT_TEXTURES;
    }
}
