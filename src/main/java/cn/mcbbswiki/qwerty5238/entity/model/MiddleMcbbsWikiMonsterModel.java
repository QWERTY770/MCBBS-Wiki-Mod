package cn.mcbbswiki.qwerty5238.entity.model;

import cn.mcbbswiki.qwerty5238.entity.MiddleMcbbsWikiMonsterEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

import javax.annotation.ParametersAreNonnullByDefault;

public class MiddleMcbbsWikiMonsterModel extends EntityModel<MiddleMcbbsWikiMonsterEntity> {
    private final ModelPart root;

    public MiddleMcbbsWikiMonsterModel(ModelPart part) {
        this.root = part;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -16.0F, -0.0F, 24.0F, 12.0F, 24.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 96, 96);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setupAnim(MiddleMcbbsWikiMonsterEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    @ParametersAreNonnullByDefault
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        root.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    public ModelPart root() {
        return this.root;
    }
}
