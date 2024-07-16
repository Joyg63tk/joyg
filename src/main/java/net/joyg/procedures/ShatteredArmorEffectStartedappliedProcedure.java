package net.joyg.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class ShatteredArmorEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
				.hasModifier((new AttributeModifier(UUID.fromString("dd988aa8-42cd-11ef-9d94-325096b39f47"), "shatterarmor", 0, AttributeModifier.Operation.MULTIPLY_TOTAL)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
					.addTransientModifier((new AttributeModifier(UUID.fromString("dd988aa8-42cd-11ef-9d94-325096b39f47"), "shatterarmor", 0, AttributeModifier.Operation.MULTIPLY_TOTAL)));
	}
}
