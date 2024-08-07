
package net.joyg.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.joyg.entity.PortalEntity;
import net.joyg.client.model.Modelportal;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PortalRenderer extends MobRenderer<PortalEntity, Modelportal<PortalEntity>> {
	public PortalRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelportal(context.bakeLayer(Modelportal.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<PortalEntity, Modelportal<PortalEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("joyg:textures/entities/portal.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, PortalEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelportal(Minecraft.getInstance().getEntityModels().bakeLayer(Modelportal.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(PortalEntity entity) {
		return new ResourceLocation("joyg:textures/entities/portal.png");
	}
}
