package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntombAffixProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("healthy_affix") == true) {
			entity.getPersistentData().putDouble("entomb", (entity.getPersistentData().getDouble("entomb") + 1));
			if (entity.getPersistentData().getDouble("entomb") > 100 && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player) {
				entity.getPersistentData().putDouble("entomb", 0);
				if (world instanceof ServerLevel _level)
					FallingBlockEntity.fall(_level, BlockPos.containing((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(), (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 2,
							(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), Blocks.SAND.defaultBlockState());
				if (world instanceof ServerLevel _level)
					FallingBlockEntity.fall(_level, BlockPos.containing((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(), (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 3,
							(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), Blocks.SAND.defaultBlockState());
			}
		}
	}
}
