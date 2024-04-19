package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.joyg.init.JoygModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaLeechPProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(DamageSource damagesource, Entity sourceentity, double amount) {
		execute(null, damagesource, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity sourceentity, double amount) {
		if (damagesource == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if (((LivingEntity) sourceentity).getAttribute(JoygModAttributes.MANALEECH.get()).getValue() > 0 && !damagesource.isIndirect()) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("mana add @p " + Math.round(amount * ((LivingEntity) sourceentity).getAttribute(JoygModAttributes.MANALEECH.get()).getValue())));
					}
				}
			}
		}
	}
}
