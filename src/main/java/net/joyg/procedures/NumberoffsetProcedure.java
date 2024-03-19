package net.joyg.procedures;

import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;

public class NumberoffsetProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma > 9) {
			return false;
		}
		return true;
	}
}
