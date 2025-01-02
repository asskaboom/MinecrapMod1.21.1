package net.tony.minecrap;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.tony.minecrap.entity.ModEntities;
import net.tony.minecrap.entity.client.AmogusModel;
import net.tony.minecrap.entity.client.AmogusRenderer;

public class MinecrapModClient implements ClientModInitializer{
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(AmogusModel.AMOGUS, AmogusModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.AMOGUS, AmogusRenderer::new);

    }
}

