
package net.joyg.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BarbedArrowMobEffect extends MobEffect {
	public BarbedArrowMobEffect() {
		super(MobEffectCategory.HARMFUL, -3407872);
	}

	@Override
	public String getDescriptionId() {
		return "effect.joyg.barbed_arrow";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
