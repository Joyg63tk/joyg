package net.joyg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.joyg.init.JoygModMobEffects;

public class BleedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("joyg:bleeding")))),
				(float) (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.BLEED.get()) ? _livEnt.getEffect(JoygModMobEffects.BLEED.get()).getAmplifier() : 0)));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LANDING_LAVA, x, y, z, 5, 1, 2, 1, (-0.1));
	}
}
