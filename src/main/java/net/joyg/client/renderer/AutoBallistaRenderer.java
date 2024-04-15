
package net.joyg.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.joyg.entity.AutoBallistaEntity;
import net.joyg.client.model.Modelballista;

public class AutoBallistaRenderer extends MobRenderer<AutoBallistaEntity, Modelballista<AutoBallistaEntity>> {
	public AutoBallistaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelballista(context.bakeLayer(Modelballista.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AutoBallistaEntity entity) {
		return new ResourceLocation("joyg:textures/entities/ballista.png");
	}
}
