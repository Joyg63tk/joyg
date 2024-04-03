package net.joyg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.joyg.network.JoygModVariables;
import net.joyg.entity.PortalEntity;

import java.util.List;
import java.util.Comparator;

public class PortalOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("age", (entity.getPersistentData().getDouble("age") + 1));
		if (entity.getPersistentData().getDouble("age") >= 6000) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, 1, 0.5, 2, 0.5, 0.3);
		if ((entity instanceof PortalEntity _datEntL5 && _datEntL5.getEntityData().get(PortalEntity.DATA_home)) == true) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PortalEntity) {
						if (!(entityiterator == entity) && (entityiterator instanceof PortalEntity _datEntS ? _datEntS.getEntityData().get(PortalEntity.DATA_owner) : "")
								.contains(entity instanceof PortalEntity _datEntS ? _datEntS.getEntityData().get(PortalEntity.DATA_owner) : "") && entityiterator.getPersistentData().getDouble("age") > entity.getPersistentData().getDouble("age")) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
						}
					}
				}
			}
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PortalEntity) {
						if (!(entityiterator == entity)
								&& (entityiterator instanceof PortalEntity _datEntS ? _datEntS.getEntityData().get(PortalEntity.DATA_owner) : "")
										.contains(entity instanceof PortalEntity _datEntS ? _datEntS.getEntityData().get(PortalEntity.DATA_owner) : "")
								&& entityiterator.getPersistentData().getDouble("age") > entity.getPersistentData().getDouble("age")
								&& (entityiterator instanceof PortalEntity _datEntL20 && _datEntL20.getEntityData().get(PortalEntity.DATA_home)) == false) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
						}
					}
					if (entityiterator instanceof Player) {
						if (((entityiterator.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).portalTaken)
								.contains(entity instanceof PortalEntity _datEntS ? _datEntS.getEntityData().get(PortalEntity.DATA_owner) : "")
								&& (entityiterator.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).portal == true) {
							{
								boolean _setval = false;
								entityiterator.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.portal = _setval;
									capability.syncPlayerVariables(entityiterator);
								});
							}
							if (!entity.level().isClientSide())
								entity.discard();
						}
					}
				}
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + 1), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
