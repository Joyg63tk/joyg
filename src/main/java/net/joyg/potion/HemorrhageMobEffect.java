
package net.joyg.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.joyg.procedures.HemorrhageOnEffectActiveTickProcedure;
import net.joyg.procedures.HemorrhageActiveTickConditionProcedure;

public class HemorrhageMobEffect extends MobEffect {
	public HemorrhageMobEffect() {
		super(MobEffectCategory.HARMFUL, -3407872);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		HemorrhageOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return HemorrhageActiveTickConditionProcedure.execute(duration);
	}
}
