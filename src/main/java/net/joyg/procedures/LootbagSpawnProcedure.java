package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.joyg.init.JoygModEntities;
import net.joyg.entity.LootbagEEntity;
import net.joyg.JoygMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LootbagSpawnProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		JoygMod.queueServerWork(5, () -> {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JoygModEntities.LOOTBAG_E.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				if ((entitytospawn) instanceof LootbagEEntity _datEntSetS)
					_datEntSetS.getEntityData().set(LootbagEEntity.DATA_owner, (sourceentity.getStringUUID()));
				if (sourceentity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
					if ((entitytospawn) instanceof LootbagEEntity _datEntSetS)
						_datEntSetS.getEntityData().set(LootbagEEntity.DATA_owner, ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getStringUUID()));
				}
			}
		});
	}
}
