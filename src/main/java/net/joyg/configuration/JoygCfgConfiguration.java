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
	public static final ForgeConfigSpec.ConfigValue<Boolean> DPOPERATION;
	public static final ForgeConfigSpec.ConfigValue<Double> DPAMOUNT;
	public static final ForgeConfigSpec.ConfigValue<Double> LOOTING;
	public static final ForgeConfigSpec.ConfigValue<Double> FORTUNE;
	public static final ForgeConfigSpec.ConfigValue<Double> LUCK;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_LOOT;
	public static final ForgeConfigSpec.ConfigValue<Double> LOOT_TIME;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ELITE_AFFIX;
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
		DPOPERATION = BUILDER.comment("when player dies their karma is operated in this way. this is a logic variable, true will multiply the karma by the dpamount number, false will sum the karma with the dpamount number. Default value: true")
				.define("karma death penalty operation", true);
		DPAMOUNT = BUILDER.comment(
				"number the player karma will be operated by when they die. if death penalty operation is true karma will be MULTIPLIED by this amount then rounded down, use decimals to divide. if death penalty operation is false the karma will be added to this number then rounded, use negative numbers to substract. Default value: 0.5")
				.define("death penalty amount", (double) 0.5);
		BUILDER.pop();
		BUILDER.push("Karma Bonuses");
		LOOTING = BUILDER.comment("number of karma levels required to grant an additional lvl of Looting, Default value: 5").define("karma lvl for each Looting lvl", (double) 5);
		FORTUNE = BUILDER.comment("number of karma levels required to grant an additional lvl of Fortune, Default value: 3").define("karma lvl for each Fortune lvl", (double) 3);
		LUCK = BUILDER.comment("number of karma levels required to grant an additional lvl of Luck, Default value: 1").define("karma lvl for each Luck lvl", (double) 1);
		BUILDER.pop();
		BUILDER.push("Loot alocation");
		ENABLE_LOOT = BUILDER.comment("whether loot alocation is enabled, True will store loot from killed enemies so only the person who landed the killing blow can loot it until the loot bag despawns and releases the items").define("enable loot",
				true);
		LOOT_TIME = BUILDER.comment("amount of ticks loot is protected before the loot bag despawns and items drop to the ground").define("alocation ticks", (double) 400);
		BUILDER.pop();
		BUILDER.push("Elite Affixes");
		ELITE_AFFIX = BUILDER.comment("Enable Elite mobs gaining random affixes based on the Karma lvl of nearby players when the mob spawns. to disable affixes check config folder/joyg_affix.json").define("Enable elite affixes", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
