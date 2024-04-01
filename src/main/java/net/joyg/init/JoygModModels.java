
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.joyg.client.model.Modellootsack_Converted;
import net.joyg.client.model.Modeldragonwings;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class JoygModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeldragonwings.LAYER_LOCATION, Modeldragonwings::createBodyLayer);
		event.registerLayerDefinition(Modellootsack_Converted.LAYER_LOCATION, Modellootsack_Converted::createBodyLayer);
	}
}
