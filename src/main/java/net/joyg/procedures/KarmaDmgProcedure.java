package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.joyg.network.JoygModVariables;
import net.joyg.init.JoygModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KarmaDmgProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player) {
			if (sourceentity instanceof Mob) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
						Math.round(Math.max(amount * (entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma * JoygModVariables.MapVariables.get(world).karmaDmg,
								entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)));
				if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma >= JoygModVariables.MapVariables.get(world).karmaSlowness) {
					if (Math.random() <= (entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma * JoygModVariables.MapVariables.get(world).karmaEffChance) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) Math.round(JoygModVariables.MapVariables.get(world).karmaEffDuration),
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) + 1), false, false));
					}
				}
				if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma >= JoygModVariables.MapVariables.get(world).karmaWeakness) {
					if (Math.random() <= (entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma * JoygModVariables.MapVariables.get(world).karmaEffChance) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int) Math.round(JoygModVariables.MapVariables.get(world).karmaEffDuration),
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1), false, false));
					}
				}
				if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma >= JoygModVariables.MapVariables.get(world).karmaPoison) {
					if (Math.random() <= (entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma * JoygModVariables.MapVariables.get(world).karmaEffChance) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.POISON, (int) Math.round(JoygModVariables.MapVariables.get(world).karmaEffDuration),
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.POISON) ? _livEnt.getEffect(MobEffects.POISON).getAmplifier() : 0) + 1), false, false));
					}
				}
				if ((entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma >= JoygModVariables.MapVariables.get(world).karmaBleed) {
					if (Math.random() <= (entity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma * JoygModVariables.MapVariables.get(world).karmaEffChance) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JoygModMobEffects.BLEED.get(), (int) Math.round(JoygModVariables.MapVariables.get(world).karmaEffDuration),
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.BLEED.get()) ? _livEnt.getEffect(JoygModMobEffects.BLEED.get()).getAmplifier() : 0) + 1), false, false));
					}
				}
			}
		}
	}
}
