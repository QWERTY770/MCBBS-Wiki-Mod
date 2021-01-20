package cn.mcbbswiki.qwerty5238.entity.model;

import cn.mcbbswiki.qwerty5238.entity.LargeMcbbsWikiMonsterEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.annotation.ParametersAreNonnullByDefault;

public class LargeMcbbsWikiMonsterModel extends EntityModel<LargeMcbbsWikiMonsterEntity> {
    private final ModelRenderer body;

    public LargeMcbbsWikiMonsterModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(8.0F, 24.0F, -8.0F);
        body.setTextureOffset(0, 0).addBox(-16.0F, -16.0F, 0.0F, 32.0F, 16.0F, 32.0F, 0.0F, false);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(LargeMcbbsWikiMonsterEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }
}
