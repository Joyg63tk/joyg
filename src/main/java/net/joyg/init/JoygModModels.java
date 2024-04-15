
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.joyg.client.model.Modeltotem;
import net.joyg.client.model.Modelportal;
import net.joyg.client.model.Modellootsack_Converted;
import net.joyg.client.model.Modelfamiliar;
import net.joyg.client.model.Modeldragonwings;
import net.joyg.client.model.Modelballista;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class JoygModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeldragonwings.LAYER_LOCATION, Modeldragonwings::createBodyLayer);
		event.registerLayerDefinition(Modelfamiliar.LAYER_LOCATION, Modelfamiliar::createBodyLayer);
		event.registerLayerDefinition(Modellootsack_Converted.LAYER_LOCATION, Modellootsack_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelballista.LAYER_LOCATION, Modelballista::createBodyLayer);
		event.registerLayerDefinition(Modelportal.LAYER_LOCATION, Modelportal::createBodyLayer);
		event.registerLayerDefinition(Modeltotem.LAYER_LOCATION, Modeltotem::createBodyLayer);
	}
}
