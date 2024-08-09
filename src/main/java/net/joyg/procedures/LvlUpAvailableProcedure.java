package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.joyg.network.JoygModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LvlUpAvailableProcedure {
	@SubscribeEvent
	public static void onPlayerXPLevelChange(PlayerXpEvent.LevelChange event) {
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
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 10 * (entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).level) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Tienes suficientes Niveles para Entrenar un Passivo, presiona K (predeterminado)"), false);
		}
	}
}
