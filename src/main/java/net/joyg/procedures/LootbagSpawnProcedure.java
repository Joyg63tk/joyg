package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.joyg.configuration.JoygCfgConfiguration;
import net.joyg.JoygMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LootbagSpawnProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer || (sourceentity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
			if (JoygCfgConfiguration.ENABLE_LOOT.get() == true) {
				JoygMod.queueServerWork(5, () -> {
				});
			}
		}
	}
}
