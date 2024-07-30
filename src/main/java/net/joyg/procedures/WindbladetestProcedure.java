package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.joyg.init.JoygModEntities;
import net.joyg.entity.WindbladeEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WindbladetestProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _serverLevel) {
			Entity entityinstance = JoygModEntities.WINDBLADE.get().create(_serverLevel, null, null, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED, false, false);
			if (entityinstance != null) {
				entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
				if (entityinstance instanceof TamableAnimal _toTame && entity instanceof Player _owner)
					_toTame.tame(_owner);
				if (entityinstance instanceof WindbladeEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WindbladeEntity.DATA_damage, 0);
				entityinstance.setDeltaMovement(new Vec3((5 * entity.getLookAngle().x), 0, (5 * entity.getLookAngle().z)));
				_serverLevel.addFreshEntity(entityinstance);
			}
		}
	}
}
