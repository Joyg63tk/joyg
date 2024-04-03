package net.joyg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.joyg.init.JoygModEntities;
import net.joyg.entity.PortalEntity;

public class PortalScrollRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude()) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			itemstack.shrink(1);
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JoygModEntities.PORTAL.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				if ((entitytospawn) instanceof PortalEntity _datEntSetS)
					_datEntSetS.getEntityData().set(PortalEntity.DATA_owner, (entity.getStringUUID()));
				if ((entitytospawn) instanceof PortalEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PortalEntity.DATA_x,
							(int) ((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level().getLevelData().getXSpawn())
									: 0));
				if ((entitytospawn) instanceof PortalEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PortalEntity.DATA_y,
							(int) ((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level().getLevelData().getYSpawn())
									: 0));
				if ((entitytospawn) instanceof PortalEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PortalEntity.DATA_z,
							(int) ((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level().getLevelData().getZSpawn())
									: 0));
				(entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString() + "'s portal")));
			}
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JoygModEntities.PORTAL.get().spawn(_serverLevel,
						BlockPos.containing(
								((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
										? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level().getLevelData().getXSpawn())
										: 0),
								((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
										? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level().getLevelData().getYSpawn())
										: 0),
								((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
										? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level().getLevelData().getZSpawn())
										: 0)),
						MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				if ((entitytospawn) instanceof PortalEntity _datEntSetS)
					_datEntSetS.getEntityData().set(PortalEntity.DATA_owner, (entity.getStringUUID()));
				if ((entitytospawn) instanceof PortalEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PortalEntity.DATA_x, (int) entity.getX());
				if ((entitytospawn) instanceof PortalEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PortalEntity.DATA_y, (int) entity.getY());
				if ((entitytospawn) instanceof PortalEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PortalEntity.DATA_z, (int) entity.getZ());
				if ((entitytospawn) instanceof PortalEntity _datEntSetL)
					_datEntSetL.getEntityData().set(PortalEntity.DATA_home, true);
				(entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString() + "'s portal")));
			}
		}
	}
}
