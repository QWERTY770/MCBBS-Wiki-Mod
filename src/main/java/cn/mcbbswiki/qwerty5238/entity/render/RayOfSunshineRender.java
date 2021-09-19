package cn.mcbbswiki.qwerty5238.entity.render;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.RayOfSunshineEntity;
import cn.mcbbswiki.qwerty5238.entity.model.RayOfSunshineModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class RayOfSunshineRender extends MobRenderer<RayOfSunshineEntity, RayOfSunshineModel> {
    private static final ResourceLocation DEFAULT_TEXTURES = McbbsWiki.locate("textures/entity/boss/ray_of_sunshine_default.png");
    private static final ResourceLocation FIREBALL_TEXTURES = McbbsWiki.locate("textures/entity/boss/ray_of_sunshine_fireball.png");
    private static final ResourceLocation FLUID_TEXTURES = McbbsWiki.locate("textures/entity/boss/ray_of_sunshine_fluid.png");

    public RayOfSunshineRender(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new RayOfSunshineModel(), 3F);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ResourceLocation getTextureLocation(RayOfSunshineEntity entity) {
        return switch (entity.getAttackState()) {
            case 1 -> FIREBALL_TEXTURES;
            case 2 -> FLUID_TEXTURES;
            default -> DEFAULT_TEXTURES;
        };
    }
}
