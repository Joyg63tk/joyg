package net.joyg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.joyg.entity.TotemEntity;

public class TotemOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TotemEntity _datEntSetI)
			_datEntSetI.getEntityData().set(TotemEntity.DATA_age, (int) ((entity instanceof TotemEntity _datEntI ? _datEntI.getEntityData().get(TotemEntity.DATA_age) : 0) + 1));
		if ((entity instanceof TotemEntity _datEntI ? _datEntI.getEntityData().get(TotemEntity.DATA_age) : 0) >= 600) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as " + entity.getStringUUID() + " at " + entity.getStringUUID() + " anchored feet run particle " + "POOF".replaceAll("(?i)CUSTOM:", "joyg:").toLowerCase() + " ~ ~1 ~ 0 0 0 0.00001 10");
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
