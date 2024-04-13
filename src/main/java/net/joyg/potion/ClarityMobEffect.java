
package net.joyg.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

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
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return ClarityActiveTickConditionProcedure.execute(duration);
	}
}
