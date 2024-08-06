
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.joyg.potion.ThunderCallMobEffect;
import net.joyg.potion.SufferingMobEffect;
import net.joyg.potion.Str3MobEffect;
import net.joyg.potion.Str2MobEffect;
import net.joyg.potion.Str1MobEffect;
import net.joyg.potion.SplinterMobEffect;
import net.joyg.potion.SoulReapMobEffect;
import net.joyg.potion.ShatteredArmorMobEffect;
import net.joyg.potion.Rule3MobEffect;
import net.joyg.potion.Res3MobEffect;
import net.joyg.potion.Res2MobEffect;
import net.joyg.potion.Res1MobEffect;
import net.joyg.potion.NatureLvlIconMobEffect;
import net.joyg.potion.MaxAbsorbIconMobEffect;
import net.joyg.potion.MarkedMobEffect;
import net.joyg.potion.ManathornMobEffect;
import net.joyg.potion.ManaonhitChanceIconMobEffect;
import net.joyg.potion.ManaonhitAmountIconMobEffect;
import net.joyg.potion.ManaLeechIconMobEffect;
import net.joyg.potion.ManaChargedWeaponMobEffect;
import net.joyg.potion.ManaChargeMobEffect;
import net.joyg.potion.MaimIconMobEffect;
import net.joyg.potion.LightingLvlIconMobEffect;
import net.joyg.potion.IntIconMobEffect;
import net.joyg.potion.Int3MobEffect;
import net.joyg.potion.Int2IconMobEffect;
import net.joyg.potion.ImmolationMobEffect;
import net.joyg.potion.IceLvlIconMobEffect;
import net.joyg.potion.HpIconMobEffect;
import net.joyg.potion.HolyLvlIconMobEffect;
import net.joyg.potion.HemorrhageMobEffect;
import net.joyg.potion.FlameBrandWeaponMobEffect;
import net.joyg.potion.FireLvlIconMobEffect;
import net.joyg.potion.FinalBlowMobEffect;
import net.joyg.potion.EvocationLvlIconMobEffect;
import net.joyg.potion.EscapeArtistCDIndicatorMobEffect;
import net.joyg.potion.EnvenomIconMobEffect;
import net.joyg.potion.EnderLvlIconMobEffect;
import net.joyg.potion.DisorientMobEffect;
import net.joyg.potion.Dex3MobEffect;
import net.joyg.potion.Dex2MobEffect;
import net.joyg.potion.Dex1MobEffect;
import net.joyg.potion.ClarityMobEffect;
import net.joyg.potion.BloodMeldMobEffect;
import net.joyg.potion.BloodLvlIconMobEffect;
import net.joyg.potion.BloodFrenzyMobEffect;
import net.joyg.potion.BleedMobEffect;
import net.joyg.potion.BarrageChargeMobEffect;
import net.joyg.potion.BarbedArrowMobEffect;
import net.joyg.potion.AbsorbRegenIconMobEffect;
import net.joyg.potion.AbsorbDelayIconMobEffect;
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
	public static final RegistryObject<MobEffect> MANA_CHARGED_WEAPON = REGISTRY.register("mana_charged_weapon", () -> new ManaChargedWeaponMobEffect());
	public static final RegistryObject<MobEffect> BARRAGE_CHARGE = REGISTRY.register("barrage_charge", () -> new BarrageChargeMobEffect());
	public static final RegistryObject<MobEffect> HEMORRHAGE = REGISTRY.register("hemorrhage", () -> new HemorrhageMobEffect());
	public static final RegistryObject<MobEffect> BLOOD_FRENZY = REGISTRY.register("blood_frenzy", () -> new BloodFrenzyMobEffect());
	public static final RegistryObject<MobEffect> BLOOD_MELD = REGISTRY.register("blood_meld", () -> new BloodMeldMobEffect());
	public static final RegistryObject<MobEffect> MAX_ABSORB_ICON = REGISTRY.register("max_absorb_icon", () -> new MaxAbsorbIconMobEffect());
	public static final RegistryObject<MobEffect> ABSORB_REGEN_ICON = REGISTRY.register("absorb_regen_icon", () -> new AbsorbRegenIconMobEffect());
	public static final RegistryObject<MobEffect> ABSORB_DELAY_ICON = REGISTRY.register("absorb_delay_icon", () -> new AbsorbDelayIconMobEffect());
	public static final RegistryObject<MobEffect> MANA_LEECH_ICON = REGISTRY.register("mana_leech_icon", () -> new ManaLeechIconMobEffect());
	public static final RegistryObject<MobEffect> MANAONHIT_CHANCE_ICON = REGISTRY.register("manaonhit_chance_icon", () -> new ManaonhitChanceIconMobEffect());
	public static final RegistryObject<MobEffect> MANAONHIT_AMOUNT_ICON = REGISTRY.register("manaonhit_amount_icon", () -> new ManaonhitAmountIconMobEffect());
	public static final RegistryObject<MobEffect> ENVENOM_ICON = REGISTRY.register("envenom_icon", () -> new EnvenomIconMobEffect());
	public static final RegistryObject<MobEffect> MAIM_ICON = REGISTRY.register("maim_icon", () -> new MaimIconMobEffect());
	public static final RegistryObject<MobEffect> FIRE_LVL_ICON = REGISTRY.register("fire_lvl_icon", () -> new FireLvlIconMobEffect());
	public static final RegistryObject<MobEffect> ICE_LVL_ICON = REGISTRY.register("ice_lvl_icon", () -> new IceLvlIconMobEffect());
	public static final RegistryObject<MobEffect> LIGHTING_LVL_ICON = REGISTRY.register("lighting_lvl_icon", () -> new LightingLvlIconMobEffect());
	public static final RegistryObject<MobEffect> HOLY_LVL_ICON = REGISTRY.register("holy_lvl_icon", () -> new HolyLvlIconMobEffect());
	public static final RegistryObject<MobEffect> ENDER_LVL_ICON = REGISTRY.register("ender_lvl_icon", () -> new EnderLvlIconMobEffect());
	public static final RegistryObject<MobEffect> BLOOD_LVL_ICON = REGISTRY.register("blood_lvl_icon", () -> new BloodLvlIconMobEffect());
	public static final RegistryObject<MobEffect> EVOCATION_LVL_ICON = REGISTRY.register("evocation_lvl_icon", () -> new EvocationLvlIconMobEffect());
	public static final RegistryObject<MobEffect> NATURE_LVL_ICON = REGISTRY.register("nature_lvl_icon", () -> new NatureLvlIconMobEffect());
	public static final RegistryObject<MobEffect> INT_ICON = REGISTRY.register("int_icon", () -> new IntIconMobEffect());
	public static final RegistryObject<MobEffect> INT_2_ICON = REGISTRY.register("int_2_icon", () -> new Int2IconMobEffect());
	public static final RegistryObject<MobEffect> INT_3 = REGISTRY.register("int_3", () -> new Int3MobEffect());
	public static final RegistryObject<MobEffect> STR_1 = REGISTRY.register("str_1", () -> new Str1MobEffect());
	public static final RegistryObject<MobEffect> STR_2 = REGISTRY.register("str_2", () -> new Str2MobEffect());
	public static final RegistryObject<MobEffect> STR_3 = REGISTRY.register("str_3", () -> new Str3MobEffect());
	public static final RegistryObject<MobEffect> DEX_1 = REGISTRY.register("dex_1", () -> new Dex1MobEffect());
	public static final RegistryObject<MobEffect> DEX_2 = REGISTRY.register("dex_2", () -> new Dex2MobEffect());
	public static final RegistryObject<MobEffect> DEX_3 = REGISTRY.register("dex_3", () -> new Dex3MobEffect());
	public static final RegistryObject<MobEffect> RES_1 = REGISTRY.register("res_1", () -> new Res1MobEffect());
	public static final RegistryObject<MobEffect> RES_2 = REGISTRY.register("res_2", () -> new Res2MobEffect());
	public static final RegistryObject<MobEffect> RES_3 = REGISTRY.register("res_3", () -> new Res3MobEffect());
	public static final RegistryObject<MobEffect> HP_ICON = REGISTRY.register("hp_icon", () -> new HpIconMobEffect());
	public static final RegistryObject<MobEffect> SPLINTER = REGISTRY.register("splinter", () -> new SplinterMobEffect());
	public static final RegistryObject<MobEffect> RULE_3 = REGISTRY.register("rule_3", () -> new Rule3MobEffect());
	public static final RegistryObject<MobEffect> MANATHORN = REGISTRY.register("manathorn", () -> new ManathornMobEffect());
	public static final RegistryObject<MobEffect> SUFFERING = REGISTRY.register("suffering", () -> new SufferingMobEffect());
}
