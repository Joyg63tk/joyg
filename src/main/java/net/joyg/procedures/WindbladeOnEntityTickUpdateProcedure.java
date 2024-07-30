package net.joyg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.joyg.entity.WindbladeEntity;

import java.util.List;
import java.util.Comparator;

public class WindbladeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof WindbladeEntity _datEntSetI)
			_datEntSetI.getEntityData().set(WindbladeEntity.DATA_age, (int) ((entity instanceof WindbladeEntity _datEntI ? _datEntI.getEntityData().get(WindbladeEntity.DATA_age) : 0) + 1));
		if ((entity instanceof WindbladeEntity _datEntI ? _datEntI.getEntityData().get(WindbladeEntity.DATA_age) : 0) >= 100) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SWEEP_ATTACK, x, y, z, 2, 1.5, 0, 1.5, 1);
		Vec3 motion = entity.getDeltaMovement().scale(1.1);
		entity.setDeltaMovement(motion);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof ServerPlayer) || !(entityiterator instanceof Player) || !(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.SONIC_BOOM), entity, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)),
							1);
				}
			}
		}
	}
}
