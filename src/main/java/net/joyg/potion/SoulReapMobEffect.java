
package net.joyg.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.joyg.procedures.SoulReapOnEffectActiveTickProcedure;
import net.joyg.procedures.SoulReapActiveTickConditionProcedure;

public class SoulReapMobEffect extends MobEffect {
	public SoulReapMobEffect() {
		super(MobEffectCategory.HARMFUL, -13421773);
	}

	@Override
	public String getDescriptionId() {
		return "effect.joyg.soul_reap";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SoulReapOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return SoulReapActiveTickConditionProcedure.execute(duration);
	}
}
