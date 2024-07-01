package net.joyg.procedures;

import net.minecraft.world.entity.Entity;

import net.joyg.network.JoygModVariables;

public class FinalBlowEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.finalBlow = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
