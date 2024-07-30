package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.joyg.init.JoygModParticleTypes;
import net.joyg.init.JoygModMobEffects;

import java.util.List;
import java.util.Comparator;

public class DetonateBloodCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level)
			((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("joyg:gore_cast")), SoundSource.PLAYERS, 1, 1);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JoygModMobEffects.HEMORRHAGE.get())) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JoygModParticleTypes.BLOOD_SPLASH.get()), x, y, z, 5, 3, 3, 3, 1);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.1));
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("joyg:bleeding"))), entity),
							(float) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.HEMORRHAGE.get()) ? _livEnt.getEffect(JoygModMobEffects.HEMORRHAGE.get()).getAmplifier() : 0) * 10));
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(JoygModMobEffects.HEMORRHAGE.get());
				}
			}
		}
	}
}
