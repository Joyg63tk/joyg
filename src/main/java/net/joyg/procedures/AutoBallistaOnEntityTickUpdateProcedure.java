package net.joyg.procedures;

import net.minecraft.world.entity.Entity;

import net.joyg.entity.AutoBallistaEntity;

public class AutoBallistaOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof AutoBallistaEntity _datEntI ? _datEntI.getEntityData().get(AutoBallistaEntity.DATA_arrows) : 0) == 0) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
