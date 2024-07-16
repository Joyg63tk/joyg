
package net.joyg.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MarkedMobEffect extends MobEffect {
	public MarkedMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
