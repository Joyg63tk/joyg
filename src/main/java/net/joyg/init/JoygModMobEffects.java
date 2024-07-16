
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.joyg.potion.ThunderCallMobEffect;
import net.joyg.potion.SoulReapMobEffect;
import net.joyg.potion.ShatteredArmorMobEffect;
import net.joyg.potion.MarkedMobEffect;
import net.joyg.potion.ManaChargeMobEffect;
import net.joyg.potion.ImmolationMobEffect;
import net.joyg.potion.FlameBrandWeaponMobEffect;
import net.joyg.potion.FinalBlowMobEffect;
import net.joyg.potion.EscapeArtistCDIndicatorMobEffect;
import net.joyg.potion.DisorientMobEffect;
import net.joyg.potion.ClarityMobEffect;
import net.joyg.potion.BleedMobEffect;
import net.joyg.potion.BarbedArrowMobEffect;
import net.joyg.JoygMod;

public class JoygModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, JoygMod.MODID);
	public static final RegistryObject<MobEffect> BLEED = REGISTRY.register("bleed", () -> new BleedMobEffect());
	public static final RegistryObject<MobEffect> BARBED_ARROW = REGISTRY.register("barbed_arrow", () -> new BarbedArrowMobEffect());
	public static final RegistryObject<MobEffect> THUNDER_CALL = REGISTRY.register("thunder_call", () -> new ThunderCallMobEffect());
	public static final RegistryObject<MobEffect> CLARITY = REGISTRY.register("clarity", () -> new ClarityMobEffect());
	public static final RegistryObject<MobEffect> MANA_CHARGE = REGISTRY.register("mana_charge", () -> new ManaChargeMobEffect());
	public static final RegistryObject<MobEffect> DISORIENT = REGISTRY.register("disorient", () -> new DisorientMobEffect());
	public static final RegistryObject<MobEffect> ESCAPE_ARTIST_CD_INDICATOR = REGISTRY.register("escape_artist_cd_indicator", () -> new EscapeArtistCDIndicatorMobEffect());
	public static final RegistryObject<MobEffect> IMMOLATION = REGISTRY.register("immolation", () -> new ImmolationMobEffect());
	public static final RegistryObject<MobEffect> MARKED = REGISTRY.register("marked", () -> new MarkedMobEffect());
	public static final RegistryObject<MobEffect> SOUL_REAP = REGISTRY.register("soul_reap", () -> new SoulReapMobEffect());
	public static final RegistryObject<MobEffect> FINAL_BLOW = REGISTRY.register("final_blow", () -> new FinalBlowMobEffect());
	public static final RegistryObject<MobEffect> FLAME_BRAND_WEAPON = REGISTRY.register("flame_brand_weapon", () -> new FlameBrandWeaponMobEffect());
	public static final RegistryObject<MobEffect> SHATTERED_ARMOR = REGISTRY.register("shattered_armor", () -> new ShatteredArmorMobEffect());
}
