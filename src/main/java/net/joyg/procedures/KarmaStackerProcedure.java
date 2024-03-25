package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

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
		if (!entity.isAlive()) {
			{
				double _setval = (sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karmaBar
						+ droppedexperience * (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (double) JoygCfgConfiguration.HPMULTI.get();
				sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.karmaBar = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/attribute @p additional_attributes:looting modifier remove 69749066-e3cf-11ee-8eab-325096b39f47");
				}
			}
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("/attribute @s additional_attributes:looting modifier add 69749066-e3cf-11ee-8eab-325096b39f47 Karma "
									+ Math.floor((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma / (double) JoygCfgConfiguration.LOOTING.get()) + " add"));
				}
			}
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/attribute @s puffish_skills:player.fortune modifier remove a213cbe6-e3d2-11ee-9847-325096b39f47");
				}
			}
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("/attribute @s puffish_skills:player.fortune modifier add a213cbe6-e3d2-11ee-9847-325096b39f47 Karma "
									+ Math.floor((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma / (double) JoygCfgConfiguration.FORTUNE.get()) + " add"));
				}
			}
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/attribute @s minecraft:generic.luck modifier remove e0a8f524-e3d3-11ee-93b1-325096b39f47");
				}
			}
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("/attribute @s minecraft:generic.luck modifier add e0a8f524-e3d3-11ee-93b1-325096b39f47 Karma "
									+ Math.floor((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma / (double) JoygCfgConfiguration.LUCK.get()) + " add"));
				}
			}
		}
		if ((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new JoygModVariables.PlayerVariables())).karmaBar >= (sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma
						+ (sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma * ((double) JoygCfgConfiguration.KARMAXP.get() / 2)) {
			{
				double _setval = 0;
				sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.karmaBar = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma + 1;
				sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.karma = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
	}
}
