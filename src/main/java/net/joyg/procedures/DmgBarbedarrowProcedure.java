package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.joyg.network.JoygModVariables;
import net.joyg.init.JoygModMobEffects;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class DmgBarbedarrowProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JoygModMobEffects.BARBED_ARROW.get())) {
			if ((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).splinter == true) {
				if (damagesource.isIndirect()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
									(float) (amount * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.BARBED_ARROW.get()) ? _livEnt.getEffect(JoygModMobEffects.BARBED_ARROW.get()).getAmplifier() : 0) + 1) * 0.1));
						}
					}
				}
			} else {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
						(float) (amount * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.BARBED_ARROW.get()) ? _livEnt.getEffect(JoygModMobEffects.BARBED_ARROW.get()).getAmplifier() : 0) + 1) * 0.1));
			}
			if ((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).ruleofthree == true) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.BARBED_ARROW.get()) ? _livEnt.getEffect(JoygModMobEffects.BARBED_ARROW.get()).getAmplifier() : 0) > 3) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
							* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JoygModMobEffects.BARBED_ARROW.get()) ? _livEnt.getEffect(JoygModMobEffects.BARBED_ARROW.get()).getAmplifier() : 0) + 1) * 0.3));
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(JoygModMobEffects.BARBED_ARROW.get());
				}
			}
		}
	}
}
