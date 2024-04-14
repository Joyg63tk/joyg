
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.joyg.client.renderer.TotemRenderer;
import net.joyg.client.renderer.PortalRenderer;
import net.joyg.client.renderer.LootbagERenderer;
import net.joyg.client.renderer.ArcaneFamiliarRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JoygModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(JoygModEntities.LOOTBAG_E.get(), LootbagERenderer::new);
		event.registerEntityRenderer(JoygModEntities.PORTAL.get(), PortalRenderer::new);
		event.registerEntityRenderer(JoygModEntities.ARCANE_FAMILIAR.get(), ArcaneFamiliarRenderer::new);
		event.registerEntityRenderer(JoygModEntities.TOTEM.get(), TotemRenderer::new);
	}
}
