
package net.joyg.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.joyg.entity.LootbagEEntity;
import net.joyg.client.model.Modellootsack_Converted;

public class LootbagERenderer extends MobRenderer<LootbagEEntity, Modellootsack_Converted<LootbagEEntity>> {
	public LootbagERenderer(EntityRendererProvider.Context context) {
		super(context, new Modellootsack_Converted(context.bakeLayer(Modellootsack_Converted.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(LootbagEEntity entity) {
		return new ResourceLocation("joyg:textures/entities/lootsack.png");
	}
}
