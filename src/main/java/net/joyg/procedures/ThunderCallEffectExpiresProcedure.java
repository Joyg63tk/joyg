package net.joyg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.joyg.init.JoygModMobEffects;

public class ThunderCallEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.THUNDER_CALL.get()) ? _livEnt.getEffect(JoygModMobEffects.THUNDER_CALL.get()).getDuration() : 0) <= 20) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LIGHTNING_BOLT)),
					(float) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.THUNDER_CALL.get()) ? _livEnt.getEffect(JoygModMobEffects.THUNDER_CALL.get()).getAmplifier() : 0)
							* (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.THUNDER_CALL.get()) ? _livEnt.getEffect(JoygModMobEffects.THUNDER_CALL.get()).getAmplifier() : 0)));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(JoygModMobEffects.THUNDER_CALL.get());
		}
	}
}
