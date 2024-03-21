package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.joyg.init.JoygModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DmgBarbedarrowProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, double amount) {
		execute(null, world, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double amount) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JoygModMobEffects.BARBED_ARROW.get())) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
					(float) (amount * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.BARBED_ARROW.get()) ? _livEnt.getEffect(JoygModMobEffects.BARBED_ARROW.get()).getAmplifier() : 0) + 1) * 0.1));
		}
	}
}
