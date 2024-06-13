
package net.joyg.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.joyg.procedures.ImmolationOnEffectActiveTickProcedure;
import net.joyg.procedures.ImmolationActiveTickConditionProcedure;

public class ImmolationMobEffect extends MobEffect {
	public ImmolationMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.joyg.immolation";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ImmolationOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return ImmolationActiveTickConditionProcedure.execute(duration);
	}
}
