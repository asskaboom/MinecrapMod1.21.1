package net.tony.minecrap.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.tony.minecrap.Minecrap;
import net.tony.minecrap.entity.custom.AmogusEntity;

public class AmogusModel<T extends AmogusEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer AMOGUS = new EntityModelLayer(Identifier.of(Minecrap.MOD_ID, "amogus"), "main");

    private final ModelPart root;
    private final ModelPart Leftleg;
    private final ModelPart Rightleg;
    private final ModelPart Righthand;
    private final ModelPart Lefthand;
    private final ModelPart bb_main;
    public AmogusModel(ModelPart root) {
        this.root = root;
        this.Leftleg = root.getChild("Leftleg");
        this.Rightleg = root.getChild("Rightleg");
        this.Righthand = root.getChild("Righthand");
        this.Lefthand = root.getChild("Lefthand");
        this.bb_main = root.getChild("bb_main");

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Leftleg = modelPartData.addChild("Leftleg", ModelPartBuilder.create().uv(12, 36).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.5F, 18.0F, -1.5F));

        ModelPartData Rightleg = modelPartData.addChild("Rightleg", ModelPartBuilder.create().uv(0, 36).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(4.5F, 18.0F, -1.5F));

        ModelPartData Righthand = modelPartData.addChild("Righthand", ModelPartBuilder.create().uv(42, 9).cuboid(9.0F, -12.0F, -3.0F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData Lefthand = modelPartData.addChild("Lefthand", ModelPartBuilder.create().uv(42, 0).cuboid(-12.0F, -12.0F, -3.0F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -23.75F, -5.0F, 12.0F, 18.0F, 9.0F, new Dilation(0.0F))
                .uv(30, 27).cuboid(-3.0F, -22.0F, 4.0F, 6.0F, 12.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 27).cuboid(-6.0F, -20.0F, -8.0F, 12.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(AmogusEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(AmogusAnimations.ANIM_AMOGUS_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, AmogusAnimations.ANIM_AMOGUS_IDLE, ageInTicks, 1f);

    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Leftleg.render(matrices, vertexConsumer, light, overlay, color);
        Rightleg.render(matrices, vertexConsumer, light, overlay, color);
        Righthand.render(matrices, vertexConsumer, light, overlay, color);
        Lefthand.render(matrices, vertexConsumer, light, overlay, color);
        bb_main.render(matrices, vertexConsumer, light, overlay, color);


    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }
}