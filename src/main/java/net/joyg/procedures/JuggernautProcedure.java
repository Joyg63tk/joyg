package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JuggernautProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).juggernaut) {
			sourceentity.getPersistentData().putDouble("jugg", (sourceentity.getPersistentData().getDouble("jugg") + 1));
			if (sourceentity.getPersistentData().getDouble("jugg") >= 3) {
				sourceentity.getPersistentData().putDouble("jugg", 0);
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (sourceentity instanceof Player _plr ? _plr.getAbsorptionAmount() : 0)) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (sourceentity instanceof Player _plr ? _plr.getAbsorptionAmount() : 0)));
					if (entity instanceof LivingEntity _entity)
						_entity.setAbsorptionAmount(0);
				}
			}
		}
	}
}
