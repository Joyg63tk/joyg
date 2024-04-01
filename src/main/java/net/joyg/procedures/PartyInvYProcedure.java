package net.joyg.procedures;

import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.joyg.network.JoygModVariables;

import com.mojang.util.UUIDTypeAdapter;

public class PartyInvYProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).invited == true) {
			{
				Entity _entityTeam = entity;
				PlayerTeam _pt = _entityTeam.level().getScoreboard().getPlayerTeam((((new Object() {
					public Entity get(LevelAccessor _world, String _uuid) {
						try {
							if (_world instanceof ServerLevel _serverLevel) {
								return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
							}
						} catch (Exception _e) {
						}
						return null;
					}
				}).get(world, ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).invFrom))) instanceof LivingEntity _teamEnt
						&& _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt.getStringUUID()) != null
								? _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()).getName()
								: ""));
				if (_pt != null) {
					if (_entityTeam instanceof Player _player)
						_entityTeam.level().getScoreboard().addPlayerToTeam(_player.getGameProfile().getName(), _pt);
					else
						_entityTeam.level().getScoreboard().addPlayerToTeam(_entityTeam.getStringUUID(), _pt);
				}
			}
			if (((new Object() {
				public Entity get(LevelAccessor _world, String _uuid) {
					try {
						if (_world instanceof ServerLevel _serverLevel) {
							return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
						}
					} catch (Exception _e) {
					}
					return null;
				}
			}).get(world, ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).invFrom))) instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " has joined your party")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You have no pending invites"), false);
		}
	}
}
