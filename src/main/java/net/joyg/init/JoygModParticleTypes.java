
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.joyg.JoygMod;

public class JoygModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, JoygMod.MODID);
	public static final RegistryObject<SimpleParticleType> BLOOD_SPLASH = REGISTRY.register("blood_splash", () -> new SimpleParticleType(true));
}
