package net.joyg.procedures;

import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;

public class Numberoffset3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma > 99) {
			return true;
		}
		return false;
	}
}
