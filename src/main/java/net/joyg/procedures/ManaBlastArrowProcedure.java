package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.joyg.init.JoygModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaBlastArrowProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).contains("arrow") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).contains("bolt")) {
			if ((entity instanceof TraceableEntity _traceableEntity ? _traceableEntity.getOwner() : null) instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JoygModMobEffects.MANA_CHARGED_WEAPON.get())) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CRIT, x, y, z, 5, 3, 3, 3, 1);
				if (entity instanceof AbstractArrow _abstractArrow)
					_abstractArrow.setBaseDamage(((entity instanceof AbstractArrow _arrowContext ? _arrowContext.getBaseDamage() : 0.0D)
							+ ((entity instanceof TraceableEntity _traceableEntity ? _traceableEntity.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.MANA_CHARGED_WEAPON.get())
									? _livEnt.getEffect(JoygModMobEffects.MANA_CHARGED_WEAPON.get()).getAmplifier()
									: 0)));
				if ((entity instanceof TraceableEntity _traceableEntity ? _traceableEntity.getOwner() : null) instanceof LivingEntity _entity)
					_entity.removeEffect(JoygModMobEffects.MANA_CHARGED_WEAPON.get());
			}
		}
	}
}
