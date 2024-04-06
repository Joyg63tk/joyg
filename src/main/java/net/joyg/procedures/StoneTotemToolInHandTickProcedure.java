package net.joyg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class StoneTotemToolInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
			entity.getPersistentData().putDouble("totemHeld", (entity.getPersistentData().getDouble("totemHeld") + 1));
			if (entity.getPersistentData().getDouble("totemHeld") >= 400) {
				entity.getPersistentData().putDouble("totemHeld", 0);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 1, false, false));
			}
		}
	}
}
