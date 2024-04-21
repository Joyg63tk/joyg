package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.UUID;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class SoultakerAffixProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getPersistentData().getBoolean("soultaker_affix") == true) {
					if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).hasModifier((new AttributeModifier(UUID.fromString("8af95b0e-ff45-11ee-959a-325096b39f47"), "soultaker",
							Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.5), AttributeModifier.Operation.ADDITION)))))
						((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).addPermanentModifier((new AttributeModifier(UUID.fromString("8af95b0e-ff45-11ee-959a-325096b39f47"), "soultaker",
								Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.5), AttributeModifier.Operation.ADDITION)));
					if (entityiterator instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.5));
				}
			}
		}
	}
}