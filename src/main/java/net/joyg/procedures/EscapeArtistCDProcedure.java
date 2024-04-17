package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EscapeArtistCDProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).escapeArtistCD > 0) {
			{
				double _setval = (entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).escapeArtistCD - 1;
				entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.escapeArtistCD = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
