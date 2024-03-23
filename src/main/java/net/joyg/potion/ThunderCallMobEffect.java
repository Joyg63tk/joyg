
package net.joyg.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.joyg.procedures.ThunderCallEffectExpiresProcedure;

public class ThunderCallMobEffect extends MobEffect {
	public ThunderCallMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.joyg.thunder_call";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ThunderCallEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
