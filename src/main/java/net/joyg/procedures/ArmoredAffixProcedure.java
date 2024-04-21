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
public class ArmoredAffixProcedure {
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
		if (entity.getPersistentData().getBoolean("armored_affix") == true) {
			entity.getPersistentData().putBoolean("armored_affix", false);
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
					.hasModifier((new AttributeModifier(UUID.fromString("c07e1a82-ff39-11ee-97b0-325096b39f47"), "armored_affix", (2 * entity.getPersistentData().getDouble("rank")), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
						.addPermanentModifier((new AttributeModifier(UUID.fromString("c07e1a82-ff39-11ee-97b0-325096b39f47"), "armored_affix", (2 * entity.getPersistentData().getDouble("rank")), AttributeModifier.Operation.ADDITION)));
		}
	}
}
