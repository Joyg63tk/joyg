
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.joyg.JoygMod;

public class JoygModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, JoygMod.MODID);
	public static final RegistryObject<SoundEvent> HAMMER_SPAWN = REGISTRY.register("hammer_spawn", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "hammer_spawn")));
	public static final RegistryObject<SoundEvent> HAMMER_HIT = REGISTRY.register("hammer_hit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "hammer_hit")));
	public static final RegistryObject<SoundEvent> REAP = REGISTRY.register("reap", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "reap")));
	public static final RegistryObject<SoundEvent> CRASH_LIGHTNING = REGISTRY.register("crash_lightning", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "crash_lightning")));
	public static final RegistryObject<SoundEvent> MECH1 = REGISTRY.register("mech1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "mech1")));
	public static final RegistryObject<SoundEvent> EXSANGUINATE = REGISTRY.register("exsanguinate", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "exsanguinate")));
	public static final RegistryObject<SoundEvent> BLOOD_FRENZY_HEAL = REGISTRY.register("blood_frenzy_heal", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "blood_frenzy_heal")));
	public static final RegistryObject<SoundEvent> BLOOD_MELD = REGISTRY.register("blood_meld", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "blood_meld")));
	public static final RegistryObject<SoundEvent> GORESPIKE = REGISTRY.register("gorespike", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "gorespike")));
	public static final RegistryObject<SoundEvent> GORE_CAST = REGISTRY.register("gore_cast", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "gore_cast")));
	public static final RegistryObject<SoundEvent> CHORUS_CAST = REGISTRY.register("chorus_cast", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("joyg", "chorus_cast")));
}
