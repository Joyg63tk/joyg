package net.joyg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.joyg.init.JoygModParticleTypes;

public class GoreSpikeProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (JoygModParticleTypes.BLOOD_SPLASH.get()), x, y, z, 1, 0, 0, 0, 0);
	}
}
