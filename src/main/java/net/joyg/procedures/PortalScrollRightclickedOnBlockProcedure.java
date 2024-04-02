package net.joyg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.joyg.init.JoygModBlocks;

public class PortalScrollRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude())) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			world.setBlock(BlockPos.containing(x, y + 1, z), JoygModBlocks.PORTAL.get().defaultBlockState(), 3);
			itemstack.shrink(1);
		}
	}
}
