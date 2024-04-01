package net.joyg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;

public class LootbagslotsThisGUIIsOpenedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).canLoot == false) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
		if (world.isClientSide()) {
			if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).canLoot == false) {
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
		}
	}
}
