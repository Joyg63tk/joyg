
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

import net.joyg.entity.ArcaneFamiliarEntity;
import net.joyg.client.model.Modelfamiliar;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ArcaneFamiliarRenderer extends MobRenderer<ArcaneFamiliarEntity, Modelfamiliar<ArcaneFamiliarEntity>> {
	public ArcaneFamiliarRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfamiliar(context.bakeLayer(Modelfamiliar.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<ArcaneFamiliarEntity, Modelfamiliar<ArcaneFamiliarEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("joyg:textures/entities/familiar.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ArcaneFamiliarEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelfamiliar(Minecraft.getInstance().getEntityModels().bakeLayer(Modelfamiliar.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ArcaneFamiliarEntity entity) {
		return new ResourceLocation("joyg:textures/entities/familiar.png");
	}

	@Override
	protected boolean isBodyVisible(ArcaneFamiliarEntity entity) {
		return false;
	}
}
