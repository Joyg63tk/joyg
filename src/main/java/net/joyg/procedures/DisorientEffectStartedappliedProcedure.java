package net.joyg.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class DisorientEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Mob _mob) {
			_mob.setNoAi(true);
		}
	}
}
