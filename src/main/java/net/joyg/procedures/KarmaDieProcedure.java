package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;
import net.joyg.configuration.JoygCfgConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KarmaDieProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (JoygCfgConfiguration.DPOPERATION.get() == true) {
			{
				double _setval = Math.floor((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma * (double) JoygCfgConfiguration.DPAMOUNT.get());
				entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.karma = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = Math.round((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma + (double) JoygCfgConfiguration.DPAMOUNT.get());
				entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.karma = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
