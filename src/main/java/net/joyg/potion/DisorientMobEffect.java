
package net.joyg.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.joyg.procedures.DisorientOnEffectActiveTickProcedure;

public class DisorientMobEffect extends MobEffect {
	public DisorientMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777165);
	}

	@Override
	public String getDescriptionId() {
		return "effect.joyg.disorient";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DisorientOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
