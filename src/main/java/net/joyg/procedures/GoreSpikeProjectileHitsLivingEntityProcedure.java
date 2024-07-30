package net.joyg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.joyg.init.JoygModMobEffects;

public class GoreSpikeProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JoygModMobEffects.HEMORRHAGE.get())) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("joyg:bleeding"))), sourceentity),
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.HEMORRHAGE.get()) ? _livEnt.getEffect(JoygModMobEffects.HEMORRHAGE.get()).getAmplifier() : 0);
		}
	}
}
