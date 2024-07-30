
package net.joyg.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.joyg.procedures.BloodMeldEffectStartedappliedProcedure;
import net.joyg.procedures.BloodMeldEffectExpiresProcedure;

public class BloodMeldMobEffect extends MobEffect {
	public BloodMeldMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		BloodMeldEffectStartedappliedProcedure.execute(entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BloodMeldEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
