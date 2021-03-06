package cn.mcbbswiki.qwerty5238.entity.model;

import cn.mcbbswiki.qwerty5238.entity.SmallMcbbsWikiMonsterEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.annotation.ParametersAreNonnullByDefault;

public class SmallMcbbsWikiMonsterModel extends EntityModel<SmallMcbbsWikiMonsterEntity> {
    private final ModelRenderer body;

    public SmallMcbbsWikiMonsterModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this, 0, 0);
        body.addBox(-16.0F, -8.0F, 0.0F, 16.0F, 8.0F, 16.0F);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(SmallMcbbsWikiMonsterEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }
}
