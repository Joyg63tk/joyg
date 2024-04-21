package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EndergripAffixProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getPersistentData().getBoolean("endergrip_affix") == true) {
			if ((sourceentity != null ? entity.distanceTo(sourceentity) : -1) > 16) {
				{
					Entity _ent = sourceentity;
					_ent.teleportTo(x, y, z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}
