
package net.joyg.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.joyg.entity.model.BHammerModel;
import net.joyg.entity.layer.BHammerLayer;
import net.joyg.entity.BHammerEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BHammerRenderer extends GeoEntityRenderer<BHammerEntity> {
	public BHammerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BHammerModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new BHammerLayer(this));
	}

	@Override
	public RenderType getRenderType(BHammerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, BHammerEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(BHammerEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
