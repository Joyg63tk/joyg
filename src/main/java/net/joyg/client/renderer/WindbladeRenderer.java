
package net.joyg.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.joyg.entity.WindbladeEntity;
import net.joyg.client.model.Modelwindblade;

public class WindbladeRenderer extends MobRenderer<WindbladeEntity, Modelwindblade<WindbladeEntity>> {
	public WindbladeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwindblade(context.bakeLayer(Modelwindblade.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WindbladeEntity entity) {
		return new ResourceLocation("joyg:textures/entities/windblade.png");
	}
}
