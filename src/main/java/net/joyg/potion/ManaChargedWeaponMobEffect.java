
package net.joyg.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ManaChargedWeaponMobEffect extends MobEffect {
	public ManaChargedWeaponMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
