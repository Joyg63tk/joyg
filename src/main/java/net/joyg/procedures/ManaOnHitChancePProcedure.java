package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.joyg.network.JoygModVariables;
import net.joyg.init.JoygModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaOnHitChancePProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), event.getSource().getEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity sourceentity) {
		execute(null, damagesource, sourceentity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity sourceentity) {
		if (damagesource == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if (!((damagesource.getDirectEntity()) instanceof Projectile)) {
				if (Mth.nextInt(RandomSource.create(), 1, 100) <= ((LivingEntity) sourceentity).getAttribute(JoygModAttributes.MANAONHITCHANCE.get()).getValue()) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("mana add @p " + ((LivingEntity) sourceentity).getAttribute(JoygModAttributes.MANAGAINEDONHIT.get()).getValue()));
						}
					}
				}
			} else if ((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).indirectMoH == true) {
				if (Mth.nextInt(RandomSource.create(), 1, 100) <= ((LivingEntity) sourceentity).getAttribute(JoygModAttributes.MANAONHITCHANCE.get()).getValue() / 2) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("mana add @p " + ((LivingEntity) sourceentity).getAttribute(JoygModAttributes.MANAGAINEDONHIT.get()).getValue()));
						}
					}
				}
			}
		}
	}
}
