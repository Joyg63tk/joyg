
package net.joyg.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.joyg.entity.EarthSpikeEntity;
import net.joyg.client.model.Modelspike;

public class EarthSpikeRenderer extends MobRenderer<EarthSpikeEntity, Modelspike<EarthSpikeEntity>> {
	public EarthSpikeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspike(context.bakeLayer(Modelspike.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EarthSpikeEntity entity) {
		return new ResourceLocation("joyg:textures/entities/spike.png");
	}
}
