package net.joyg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityAnchorArgument;

public class DisorientOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Mob _entity) {
			_entity.setTarget(null);
		}
		entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((Direction.getRandom(RandomSource.create()).getStepX()), (Direction.getRandom(RandomSource.create()).getStepY()), (Direction.getRandom(RandomSource.create()).getStepZ())));
	}
}
