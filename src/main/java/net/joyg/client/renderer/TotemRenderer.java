
package net.joyg.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.joyg.entity.TotemEntity;
import net.joyg.client.model.Modeltotem;

public class TotemRenderer extends MobRenderer<TotemEntity, Modeltotem<TotemEntity>> {
	public TotemRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltotem(context.bakeLayer(Modeltotem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TotemEntity entity) {
		return new ResourceLocation("joyg:textures/entities/totem.png");
	}
}
