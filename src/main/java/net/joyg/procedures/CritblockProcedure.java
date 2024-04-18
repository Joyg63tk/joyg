package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.joyg.network.JoygModVariables;
import net.joyg.init.JoygModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CritblockProcedure {
	@SubscribeEvent
	public static void whenEntityBlocksWithShield(ShieldBlockEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getBlockedDamage());
		}
	}

	public static void execute(Entity entity, double blockedamount) {
		execute(null, entity, blockedamount);
	}

	private static void execute(@Nullable Event event, Entity entity, double blockedamount) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (((LivingEntity) entity).getAttribute(JoygModAttributes.CRITICALBLOCKCHANCE.get()).getValue() > Mth.nextDouble(RandomSource.create(), 0, 99)) {
				entity.invulnerableTime = 20;
				if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).unbreakableGuardian == true) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + blockedamount));
				}
			}
		}
	}
}
