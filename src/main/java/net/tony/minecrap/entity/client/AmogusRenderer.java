package net.tony.minecrap.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.tony.minecrap.Minecrap;
import net.tony.minecrap.entity.custom.AmogusEntity;
import net.tony.minecrap.entity.custom.AmogusVarient;
import net.tony.minecrap.sound.ModSounds;

import java.util.Map;
import java.util.Random;

public class AmogusRenderer extends MobEntityRenderer<AmogusEntity, AmogusModel<AmogusEntity>> {

    private final static float size = 1f;

    private static final Map<AmogusVarient, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(AmogusVarient.class), map -> {
                map.put(AmogusVarient.DEFAULT,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus.png"));
                map.put(AmogusVarient.BLUE,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_blue.png"));
                map.put(AmogusVarient.GREEN,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_green.png"));
                map.put(AmogusVarient.PINK,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_pink.png"));
                map.put(AmogusVarient.ORANGE,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_orange.png"));
                map.put(AmogusVarient.YELLOW,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_yellow.png"));
                map.put(AmogusVarient.BLACK,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_black.png"));
                map.put(AmogusVarient.WHITE,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_white.png"));
                map.put(AmogusVarient.PURPLE,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_purple.png"));
                map.put(AmogusVarient.BROWN,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_brown.png"));
                map.put(AmogusVarient.CYAN,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_cyan.png"));
                map.put(AmogusVarient.LIME,
                        Identifier.of(Minecrap.MOD_ID, "textures/entity/amogus/amogus_lime.png"));
            });


    public AmogusRenderer(EntityRendererFactory.Context context) {
        super(context, new AmogusModel<>(context.getPart(AmogusModel.AMOGUS)), 0.5f);
    }

    @Override
    public Identifier getTexture(AmogusEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(AmogusEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(size/2, size/2, size/2);
        } else {
            matrixStack.scale(size, size, size);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
