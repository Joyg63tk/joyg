package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;

import net.joyg.network.JoygModVariables;
import net.joyg.entity.PortalEntity;

public class PortalRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1);
			}
		}
		{
			Entity _ent = sourceentity;
			_ent.teleportTo((entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_x) : 0), (entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_y) : 0),
					(entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_z) : 0));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_x) : 0), (entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_y) : 0),
						(entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_z) : 0), _ent.getYRot(), _ent.getXRot());
		}
		if ((entity instanceof PortalEntity _datEntL5 && _datEntL5.getEntityData().get(PortalEntity.DATA_home)) == true) {
			{
				String _setval = entity instanceof PortalEntity _datEntS ? _datEntS.getEntityData().get(PortalEntity.DATA_owner) : "";
				sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.portalTaken = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				boolean _setval = true;
				sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.portal = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
