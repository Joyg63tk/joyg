package net.joyg.procedures;

import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;

public class Numberoffset2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma > 9
				&& (entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma < 100) {
			return true;
		}
		return false;
	}
}
