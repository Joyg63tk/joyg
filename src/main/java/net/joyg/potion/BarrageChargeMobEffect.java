
package net.joyg.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BarrageChargeMobEffect extends MobEffect {
	public BarrageChargeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
