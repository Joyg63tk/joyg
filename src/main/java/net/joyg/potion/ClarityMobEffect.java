
package net.joyg.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.joyg.procedures.ClarityOnEffectActiveTickProcedure;
import net.joyg.procedures.ClarityActiveTickConditionProcedure;

public class ClarityMobEffect extends MobEffect {
	public ClarityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16750900);
	}

	@Override
	public String getDescriptionId() {
		return "effect.joyg.clarity";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ClarityOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return ClarityActiveTickConditionProcedure.execute(duration);
	}
}
