
package net.joyg.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.joyg.procedures.BleedOnEffectActiveTickProcedure;
import net.joyg.procedures.BleedActiveTickConditionProcedure;

public class BleedMobEffect extends MobEffect {
	public BleedMobEffect() {
		super(MobEffectCategory.HARMFUL, -3407872);
	}

	@Override
	public String getDescriptionId() {
		return "effect.joyg.bleed";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BleedOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return BleedActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
