package net.joyg.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.joyg.entity.BHammerEntity;

public class BHammerModel extends GeoModel<BHammerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BHammerEntity entity) {
		return new ResourceLocation("joyg", "animations/blesshammer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BHammerEntity entity) {
		return new ResourceLocation("joyg", "geo/blesshammer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BHammerEntity entity) {
		return new ResourceLocation("joyg", "textures/entities/" + entity.getTexture() + ".png");
	}

}
