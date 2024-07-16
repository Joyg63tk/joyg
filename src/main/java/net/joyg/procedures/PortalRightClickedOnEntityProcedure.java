package net.joyg.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.joyg.network.JoygModVariables;
import net.joyg.entity.PortalEntity;

public class PortalRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			Entity _ent = sourceentity;
			_ent.teleportTo((entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_x) : 0), (entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_y) : 0),
					(entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_z) : 0));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_x) : 0), (entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_y) : 0),
						(entity instanceof PortalEntity _datEntI ? _datEntI.getEntityData().get(PortalEntity.DATA_z) : 0), _ent.getYRot(), _ent.getXRot());
		}
		if ((entity instanceof PortalEntity _datEntL4 && _datEntL4.getEntityData().get(PortalEntity.DATA_home)) == true) {
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
