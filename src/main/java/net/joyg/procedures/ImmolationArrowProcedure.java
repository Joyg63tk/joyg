package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

import net.joyg.init.JoygModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ImmolationArrowProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		if (entity.isOnFire() && damagesource.isIndirect()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(JoygModMobEffects.IMMOLATION.get(), 60, 0, false, false));
			entity.getPersistentData().putString("immoSource", (sourceentity.getStringUUID()));
		}
	}
}
