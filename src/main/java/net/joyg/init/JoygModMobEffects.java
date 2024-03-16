
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.joyg.potion.BleedMobEffect;
import net.joyg.JoygMod;

public class JoygModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, JoygMod.MODID);
	public static final RegistryObject<MobEffect> BLEED = REGISTRY.register("bleed", () -> new BleedMobEffect());
}
