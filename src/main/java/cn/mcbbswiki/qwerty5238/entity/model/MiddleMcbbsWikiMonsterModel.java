package cn.mcbbswiki.qwerty5238.entity.model;

import cn.mcbbswiki.qwerty5238.entity.MiddleMcbbsWikiMonsterEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.annotation.ParametersAreNonnullByDefault;

public class MiddleMcbbsWikiMonsterModel extends EntityModel<MiddleMcbbsWikiMonsterEntity> {
    private final ModelRenderer body;

    public MiddleMcbbsWikiMonsterModel() {
        textureWidth = 96;
        textureHeight = 96;

        body = new ModelRenderer(this, 0, 0);
        body.addBox(-16.0F, -16.0F, 0.0F, 24.0F, 12.0F, 24.0F);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(MiddleMcbbsWikiMonsterEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }
}
