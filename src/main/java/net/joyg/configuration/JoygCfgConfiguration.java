package net.joyg.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class JoygCfgConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> KARMAXP;
	public static final ForgeConfigSpec.ConfigValue<Double> HPMULTI;
	public static final ForgeConfigSpec.ConfigValue<Double> KARMADMG;
	public static final ForgeConfigSpec.ConfigValue<Double> KARMAEFF;
	public static final ForgeConfigSpec.ConfigValue<Double> WEAKNESS;
	public static final ForgeConfigSpec.ConfigValue<Double> SLOWNESS;
	public static final ForgeConfigSpec.ConfigValue<Double> POISON;
	public static final ForgeConfigSpec.ConfigValue<Double> BLEED;
	public static final ForgeConfigSpec.ConfigValue<Double> EFFDURATION;
	static {
		BUILDER.push("karma");
		KARMAXP = BUILDER.comment("amount of xp required for the base karma lvl, the amount required increases by 50% of the base each karma lvl. Default value: 1000").define("karma xp", (double) 1000);
		HPMULTI = BUILDER.comment("number the enemy health is multiplied by to determine a bonus number, the xp dropped by an enemy is then multiplied by this bonus number to determine karma xp per kill. Default value: 0.1").define("hp multiplier",
				(double) 0.1);
		KARMADMG = BUILDER.comment("amount of extra damage taken per lvl of karma, karma lvl is multiplied by this number then damage is multiplied by that number to determine extra damage taken, Default value: 0.1").define("karma damage taken",
				(double) 0.1);
		KARMAEFF = BUILDER.comment("chance for enemies to apply stacking potion effects per karma lvl. Chances are rolled for each individual effect, min:0 max:1. Default value: 0.2").define("karma effect chance", (double) 0.2);
		WEAKNESS = BUILDER.comment("minimum lvl of karma for weakness potion effect to apply when hit, this uses the karma effect chance. Default value: 3").define("min karma for weakness", (double) 3);
		SLOWNESS = BUILDER.comment("minimum lvl of karma for slowness potion effect to apply when hit, this uses the karma effect chance. Default value: 2").define("min karma for slowness", (double) 2);
		POISON = BUILDER.comment("minimum lvl of karma for poison potion effect to apply when hit, this uses the karma effect chance. Default value: 5").define("min karma for poison", (double) 5);
		BLEED = BUILDER.comment("minimum lvl of karma for bleed potion effect to apply when hit, this uses the karma effect chance. Default value: 1").define("min karma for bleed", (double) 1);
		EFFDURATION = BUILDER.comment("duration in ticks for potion effects for each karma lvl. Default value: 60").define("duration ticks per karma", (double) 60);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
