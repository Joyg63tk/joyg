package net.joyg.procedures;

import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;

public class KarmaOverlayNumProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("####").format((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma);
	}
}
