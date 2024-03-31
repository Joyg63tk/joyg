package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

import com.mojang.util.UUIDTypeAdapter;

@Mod.EventBusSubscriber
public class PickupAttributionProcedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getEntity().level(), event.getEntity(), event.getItem().getItem());
	}

	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		execute(null, world, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _teamEnt && _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt.getStringUUID()) != null
				? _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()).getName()
				: "").contains("party")) {
			if ((((new Object() {
				public Entity get(LevelAccessor _world, String _uuid) {
					try {
						if (_world instanceof ServerLevel _serverLevel) {
							return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
						}
					} catch (Exception _e) {
					}
					return null;
				}
			}).get(world, (itemstack.getOrCreateTag().getString("lootown")))) instanceof LivingEntity _teamEnt && _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt.getStringUUID()) != null
					? _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()).getName()
					: "")
					.equals(entity instanceof LivingEntity _teamEnt && _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt.getStringUUID()) != null
							? _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()).getName()
							: "")) {
				if (event != null && event.hasResult()) {
					event.setResult(Event.Result.ALLOW);
				}
			} else {
				if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		} else {
			if ((itemstack.getOrCreateTag().getString("lootown")).equals(entity.getStringUUID())) {
				if (event != null && event.hasResult()) {
					event.setResult(Event.Result.ALLOW);
				}
			} else {
				if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		}
	}
}
