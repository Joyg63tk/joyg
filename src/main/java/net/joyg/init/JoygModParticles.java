
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.joyg.client.particle.BloodSplashParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JoygModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(JoygModParticleTypes.BLOOD_SPLASH.get(), BloodSplashParticle::provider);
	}
}
