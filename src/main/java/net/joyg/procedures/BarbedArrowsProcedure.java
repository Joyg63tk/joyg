package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

import net.joyg.network.JoygModVariables;
import net.joyg.init.JoygModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BarbedArrowsProcedure {
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
		if ((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).barbedarrow == true) {
			if (damagesource.isIndirect()) {
				if (Math.random() <= 0.3) {
					if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JoygModMobEffects.BARBED_ARROW.get())) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JoygModMobEffects.BARBED_ARROW.get(),
									entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.BARBED_ARROW.get()) ? _livEnt.getEffect(JoygModMobEffects.BARBED_ARROW.get()).getDuration() : 0,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.BARBED_ARROW.get()) ? _livEnt.getEffect(JoygModMobEffects.BARBED_ARROW.get()).getAmplifier() : 0) + 1)));
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JoygModMobEffects.BARBED_ARROW.get(), 200, 0));
					}
				}
			}
		}
	}
}
