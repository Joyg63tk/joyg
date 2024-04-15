package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.Entity;

import net.joyg.entity.AutoBallistaEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BallistaArrowCounterProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof AutoBallistaEntity) {
			if (sourceentity instanceof AutoBallistaEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AutoBallistaEntity.DATA_arrows, (int) ((sourceentity instanceof AutoBallistaEntity _datEntI ? _datEntI.getEntityData().get(AutoBallistaEntity.DATA_arrows) : 0) - 1));
		}
	}
}
