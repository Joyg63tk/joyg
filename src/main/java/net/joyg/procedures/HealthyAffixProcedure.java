package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class HealthyAffixProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("healthy_affix") == true) {
			entity.getPersistentData().putBoolean("healthy_affix", false);
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
					.hasModifier((new AttributeModifier(UUID.fromString("c07e1a82-ff39-11ee-97b0-325096b39f47"), "healthy_affix", (10 * entity.getPersistentData().getDouble("rank")), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.addPermanentModifier((new AttributeModifier(UUID.fromString("c07e1a82-ff39-11ee-97b0-325096b39f47"), "healthy_affix", (10 * entity.getPersistentData().getDouble("rank")), AttributeModifier.Operation.ADDITION)));
		}
	}
}
