package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;
import net.joyg.configuration.JoygCfgConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KarmaStackerProcedure {
	@SubscribeEvent
	public static void onLivingDropXp(LivingExperienceDropEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAttackingPlayer(), event.getDroppedExperience());
		}
	}

	public static void execute(Entity entity, Entity sourceentity, double droppedexperience) {
		execute(null, entity, sourceentity, droppedexperience);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity, double droppedexperience) {
		if (entity == null || sourceentity == null)
			return;
		{
			double _setval = (sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karmaBar
					+ droppedexperience * (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (double) JoygCfgConfiguration.HPMULTI.get();
			sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.karmaBar = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
	}
}
